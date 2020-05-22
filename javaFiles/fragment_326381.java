import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;
import org.objectweb.asm.TypeReference;

public class Java8Example {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE_USE)
    public @interface MyTypeAnnotation {
        public String value();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("World!", "Type Annotations!");
        testTypeAnnotation(list, new @MyTypeAnnotation("Hello ") Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        });
        list = Arrays.asList("Type-Cast Annotations!");
        testTypeAnnotation(list,(@MyTypeAnnotation("Hello ") Consumer<String>) (p -> System.out.println(p)));
    }

    public static void testTypeAnnotation(List<String> list, Consumer<String> consumer){
        MyTypeAnnotation annotation = null;
        for (AnnotatedType t :  consumer.getClass().getAnnotatedInterfaces()) {
            annotation = t.getAnnotation(MyTypeAnnotation.class);
            if (annotation != null) {
                break;
            }
        }
        if (annotation == null) {
            // search for annotated parameter instead
            loop: for (Method method : consumer.getClass().getMethods()) {
                for (AnnotatedType t : method.getAnnotatedParameterTypes()) {
                    annotation = t.getAnnotation(MyTypeAnnotation.class);
                    if (annotation != null) {
                        break loop;
                    }
                }
            }
        }
        if (annotation == null) {
            annotation = findCastAnnotation();
        }
        for (String str : list) {
            if (annotation != null) {
                System.out.print(annotation.value());
            }
            consumer.accept(str);
        }
    }

    private static MyTypeAnnotation findCastAnnotation() {
        // foundException gets thrown, when the cast annotation is found or the search ends.
        // The found annotation will then be stored at foundAnnotation[0]
        final RuntimeException foundException = new RuntimeException();
        MyTypeAnnotation[] foundAnnotation = new MyTypeAnnotation[1];
        try {
            // (1) find the calling method
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement previous = null;
            for (int i = 0; i < stackTraceElements.length; i++) {
                if (stackTraceElements[i].getMethodName().equals("testTypeAnnotation")) {
                    previous = stackTraceElements[i+1];
                }
            }
            if (previous == null) {
                // shouldn't happen
                return null;
            }
            final String callingClassName = previous.getClassName();
            final String callingMethodName = previous.getMethodName();
            final int callingLineNumber = previous.getLineNumber();
            // (2) read and visit the calling class
            ClassReader cr = new ClassReader(callingClassName);
            cr.accept(new ClassVisitor(Opcodes.ASM5) {
                @Override
                public MethodVisitor visitMethod(int access, String name,String desc, String signature, String[] exceptions) {
                    if (name.equals(callingMethodName)) {
                        // (3) visit the calling method
                        return new MethodVisitor(Opcodes.ASM5) {
                            int lineNumber;
                            String type;
                            public void visitLineNumber(int line, Label start) {
                                this.lineNumber = line;
                            };
                            public void visitTypeInsn(int opcode, String type) {
                                if (opcode == Opcodes.CHECKCAST) {
                                    this.type = type;
                                } else{
                                    this.type = null;
                                }
                            };
                            public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
                                if (lineNumber == callingLineNumber) {
                                    // (4) visit the annotation, if this is the calling line number AND the annotation is 
                                    // of type MyTypeAnnotation AND it was a cast expression to "java.util.function.Consumer"
                                    if (desc.endsWith("Java8Example$MyTypeAnnotation;") && this.type != null && this.type.equals("java/util/function/Consumer")) {
                                        TypeReference reference = new TypeReference(typeRef);
                                        if (reference.getSort() == TypeReference.CAST) {
                                            return new AnnotationVisitor(Opcodes.ASM5) {
                                                public void visit(String name, final Object value) {
                                                    if (name.equals("value")) {
                                                        // Heureka! - we found the Cast Annotation
                                                        foundAnnotation[0] = new MyTypeAnnotation() {
                                                            @Override
                                                            public Class<? extends Annotation> annotationType() {
                                                                return MyTypeAnnotation.class;
                                                            }
                                                            @Override
                                                            public String value() {
                                                                return value.toString();
                                                            }
                                                        };
                                                        // stop search (Annotation found)
                                                        throw foundException;
                                                    }
                                                };
                                            };
                                        }
                                    }
                                } else if (lineNumber > callingLineNumber) {
                                    // stop search (Annotation not found)
                                    throw foundException;
                                }
                                return null;
                            };

                        };
                    }
                    return null;
                }
            }, 0);
        } catch (Exception e) {
            if (foundException == e) {
                return foundAnnotation[0];
            } else{
                e.printStackTrace();
            }
        }
        return null;
    }
}
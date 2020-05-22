import java.lang.reflect.Field;
import java.util.Arrays;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;
public class a {
  public static void main(String[] args) throws Exception {
    Class<?> klass = new ClassLoader(a.class.getClassLoader()) {
      public Class<?> defineClass() {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER,
          "Foo", null, "java/lang/Object", null);
        for (int i = 0; i < 3; i++) {
          FieldVisitor fv = cw.visitField(0, "value" + i, "I", null, null);
          fv.visitAnnotation("LBar;", true).visitEnd();
        }
        cw.visitEnd();
        byte[] bytes = cw.toByteArray();
        return defineClass("Foo", bytes, 0, bytes.length);
      }
    }.defineClass();

    for (Field f : klass.getDeclaredFields()) {
      System.out.println(f + " " + Arrays.toString(f.getAnnotations()));
    }
  }
}
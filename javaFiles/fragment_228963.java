import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.*;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

public class MethodAdapter extends ClassVisitor {


    public MethodAdapter(ClassVisitor cv) {
        super(ASM4, cv);
    }

    @Override
    public void visit(int version, int access, String name,
            String signature, String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName, interfaces);
    }


    public MethodVisitor visitMethod(int access, String name,
            String desc, String signature, String[] exceptions) {
        MethodVisitor mv;
        mv = cv.visitMethod(access, name, desc, signature, exceptions);
        mv = new AddVariableAdapter(access, name, desc, mv);
        return mv;
    }
    public void visitEnd() {
        cv.visitEnd();
    }


    public class AddVariableAdapter extends AdviceAdapter{
        public AddCallAdapter(int access, String name, String desc,  
                MethodVisitor mv) {  
            super(ASM4, mv, access, name, desc);  
        }  

        protected void onMethodEnter()  {
            mv.visitIntInsn(BIPUSH, 10); // pushes the number 10 on to the stack
            mv.visitVarInsn(ISTORE, 1);  // pops the top of the stack into a local variable indexed by 1
        /*  code to print the local variable
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(ILOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V");*/
        }
    }
}
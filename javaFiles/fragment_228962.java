import static org.objectweb.asm.Opcodes.ASM4;
import org.objectweb.asm.ClassVisitor;


class AddField extends ClassVisitor{

    static String className;
    static String methName, descrip;
    public AddField(ClassVisitor cv) {
        super(ASM4, cv);
    }

    @Override
    public void visit(int version, int access, String name,
            String signature, String superName, String[] interfaces) {
        className = name;
        cv.visit(version, access, name, signature, superName, interfaces);
    }
    public void visitEnd() {
        cv.visitField(0, "i", "I", null , new Integer(10));
        cv.visitEnd();
    }
}
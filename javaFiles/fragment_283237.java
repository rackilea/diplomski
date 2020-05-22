public class YourClassVisitor extends ClassVisitor {
    public InstrumentationClassVisitor(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        Printer p = new Textifier(Opcodes.ASM5) {
            @Override
            public void visitMethodEnd() {
                print(new PrintWriter(System.out)); // print it after it has been visited
            }
        };
        return new TraceMethodVisitor(mv, p);
    }
}
public static class ExceptionThrowerMethod extends MethodVisitor {
    private final MethodVisitor target;

    public ExceptionThrowerMethod(MethodVisitor methodVisitor) {
        super(ASM4, null);
        this.target=methodVisitor;
    }

    @Override
    public void visitCode() {
        target.visitCode();
        target.visitTypeInsn(NEW, "java/io/IOException");
        target.visitInsn(DUP);
        target.visitMethodInsn(INVOKESPECIAL,"java/io/IOException","<init>","()V",false);
        target.visitInsn(ATHROW);
        target.visitMaxs(2, 0);
        target.visitEnd();
    }
}
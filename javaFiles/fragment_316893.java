//this is the custom method visitor
private class InsertInitCodeBeforeReturnMethodVisitor extends AdviceAdapter{

    public InsertInitCodeBeforeReturnMethodVisitor(MethodVisitor mv, int access, String name, String desc) {
        super(Opcodes.ASM4, mv, access, name, desc);
    }

    @Override
    protected void onMethodExit(int opcode) {
        if(opcode != Opcdoes.ATHROW) {
            mv.visitVarInsn(Opcodes.ALOAD, 42);
        }
    }
}
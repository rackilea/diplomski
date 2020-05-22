static class Transformator extends MethodVisitor {
    int lastLineNumber;

    public Transformator(MethodVisitor mv) {
        super(Opcodes.ASM5, mv);
    }
    public void visitLineNumber(int line, Label start) {
        lastLineNumber = line;
        super.visitLineNumber(line, start);
    }
    private void checkLineNumber() {
        if(lastLineNumber > 0) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, classpath,"visitLine","()V", false);
            lastLineNumber = 0;
        }
    }
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        checkLineNumber();
        super.visitTryCatchBlock(start, end, handler, type);
    }
    public void visitMultiANewArrayInsn(String descriptor, int numDimensions) {
        checkLineNumber();
        super.visitMultiANewArrayInsn(descriptor, numDimensions);
    }
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        checkLineNumber();
        super.visitLookupSwitchInsn(dflt, keys, labels);
    }
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        checkLineNumber();
        super.visitTableSwitchInsn(min, max, dflt, labels);
    }
    public void visitIincInsn(int var, int increment) {
        checkLineNumber();
        super.visitIincInsn(var, increment);
    }
    public void visitLdcInsn(Object value) {
        checkLineNumber();
        super.visitLdcInsn(value);
    }
    public void visitJumpInsn(int opcode, Label label) {
        checkLineNumber();
        super.visitJumpInsn(opcode, label);
    }
    public void visitInvokeDynamicInsn(
        String name, String desc, Handle bsmHandle, Object... bsmArg) {
        checkLineNumber();
        super.visitInvokeDynamicInsn(name, desc, bsmHandle, bsmArg);
    }
    public void visitMethodInsn(
        int opcode, String owner, String name, String desc, boolean iface) {
        checkLineNumber();
        super.visitMethodInsn(opcode, owner, name, desc, iface);
    }
    public void visitFieldInsn(int opcode, String owner, String name,String descriptor) {
        checkLineNumber();
        super.visitFieldInsn(opcode, owner, name, descriptor);
    }
    public void visitTypeInsn(int opcode, String type) {
        checkLineNumber();
        super.visitTypeInsn(opcode, type);
    }
    public void visitVarInsn(int opcode, int var) {
        checkLineNumber();
        super.visitVarInsn(opcode, var);
    }
    public void visitIntInsn(int opcode, int operand) {
        checkLineNumber();
        super.visitIntInsn(opcode, operand);
    }
    public void visitInsn(int opcode) {
        checkLineNumber();
        super.visitInsn(opcode);
    }
}
static class ReplaceStringConstant extends MethodVisitor {
    private final String matchString, replaceWith;

    ReplaceStringConstant(MethodVisitor writer, String match, String replacement) {
        // now passing the writer to the superclass, as most code stays unchanged
        super(Opcodes.ASM5, writer);
        matchString = match;
        replaceWith = replacement;
    }

    @Override
    public void visitLdcInsn(Object cst) {
        super.visitLdcInsn(matchString.equals(cst)? replaceWith: cst);
    }
}
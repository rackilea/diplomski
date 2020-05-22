//this is the custom method visitor
private class InsertInitCodeBeforeReturnMethodVisitor extends MethodVisitor{

    public InsertInitCodeBeforeReturnMethodVisitor(MethodVisitor mv) {
        super(Opcodes.ASM4, mv);
    }

    @Override
    public void visitInsn(int opcode) {
        //whenever we find a RETURN, we instert the code, here only crazy example code
        switch(opcode) {
          case Opcodes.IRETURN:
      case Opcodes.FRETURN:
      case Opcodes.ARETURN:
      case Opcodes.LRETURN:
      case Opcodes.DRETURN:
      case Opcodes.RETURN:
              mv.visitVarInsn(Opcodes.ALOAD, 42);
              break;
          default: // do nothing
        }
        super.visitInsn(opcode);
    }
}
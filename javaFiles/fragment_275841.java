private static final class MethodReplaceMethodVisitor extends GeneratorAdapter {

  public MethodReplaceMethodVisitor(
      MethodVisitor mv, int access, String name, String desc) {
      super(mv, access, name, desc);
  }

  @Override
  public void visitMethodInsn(
      int opcode, String owner, String name, String desc, boolean itf) {

      if(opcode==Opcodes.INVOKEVIRTUAL && owner.equals("org/json/JSONObject")
      && name.equals("toString") && desc.equals("()Ljava/lang/String;")) {
        // not relaying the original instruction to super effectively removes the original 
        // instruction, instead we're producing a different instruction:
        super.visitMethodInsn(Opcodes.INVOKESTATIC, "whatever/package/JSONReplacement",
          "jsonToString", "(Lorg/json/JSONObject;)Ljava/lang/String;", false);
      }
      else // relaying to super will reproduce the same instruction
        super.visitMethodInsn(opcode, owner, name, desc, itf);
  }

  // all other, not overridden visit methods reproduce the original instructions
}
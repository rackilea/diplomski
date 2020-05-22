class TransformingClassVisitor extends ClassVisitor {
  TransformingClassVisitor(ClassVisitor cv) { super(Opcodes.ASM5, cv); }

  @Override
  public MethodVisitor visitMethod(int opcode, String name, String owner, String desc, String signature, boolean iFace) {
    MethodVisitor mv = super.visitMethod(opcodes, name, owner, desc, signature, iFace);
    if (<isTransformedMethod>) {
      return new TransformingMethodVisitor(mv);
    }
    return mv;
  }

  @Override
  public void visitEnd() {
    MethodVisitor m1 = super.visitMethod(<firstMethod>);
    implement1(m1);

    MethodVisitor m2 = super.visitMethod(<secondMethod>);
    implement1(m2);

    super.visitEnd();
  }
}
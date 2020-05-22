ClassReader cr = new ClassReader(is);
cr.accept(new EmptyVisitor() {
  public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
    if((Opcodes.ACC_PUBLIC & access)>0) {
      System.err.println("method name: " + name);
      System.err.println("return type: " + Type.getReturnType(desc));
      System.err.println("argument types: " + Arrays.toString(Type.getArgumentTypes(desc)));
    }
    return super.visitMethod(access, name, desc, signature, exceptions);
  }
}, 0);
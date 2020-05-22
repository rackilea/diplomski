class FieldAlterationAgent {
  public static void premain(String args, Instrumentation inst) {
    instrumentation.addTransformer(new ClassFileTransformer() {
      @Override
      public void byte[] transform(ClassLoader loader,
                                   String className,
                                   Class<?> classBeingRedefined,
                                   ProtectionDomain protectionDomain,
                                   byte[] classfileBuffer)
          throws IllegalClassFormatException {
        if (!className.equals("X") {
          return classFileBuffer;
        }
        ClassWriter classWriter = new ClassWriter(new ClassVisitor() {
          @Override
          public FieldVisitor visitField(int access, 
                                         String name, 
                                         String desc, 
                                         String signature, 
                                         Object value) {
            if(name.equals("timeout") {
              value = 42L; // set value here, make sure its a long!
            }
            return super.visitField(access, name, desc, signature, value);
          }
        }, 0);
        new ClassReader(classFileBuffer).accept(classWriter);
        return classWriter.toByteArray();
      }
    });
  }
}
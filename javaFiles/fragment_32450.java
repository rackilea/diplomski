instrumentation.addClassFileTransformer(
  (Module module, ClassLoader loader, String name, 
   Class<?> classIfLoaded, ProtectionDomain pd, byte[] classFile) -> {
     byte[] transformed = doSomethingWith(classFile);
     return transformed;
});
public Class<?> performThis() throws Exception {
    final ClassPool classPool = ClassPool.getDefault();
    final CtClass internalClass = classPool.get("javassist.MyClass");
    // Prevent the "frozen class issue"
    internalClass.defrost();
    ...
    return internalClass.toClass();
}
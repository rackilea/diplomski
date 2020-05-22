public byte[] transform(ClassLoader loader, String className,
        Class redefiningClass, ProtectionDomain domain, byte[] bytes)
        throws IllegalClassFormatException {
    new RuntimeException("Transformer to Transform Class: " + className)
            .printStackTrace(System.out);
    return bytes;
}
public byte[] transform(ClassLoader l, String className, Class<?> c,
        ProtectionDomain pd, byte[] b) throws IllegalClassFormatException {
    System.out.print("Loading class: ");
    System.out.println(className);
    return b;
}
public void printMethodStubs(JarFile jarFile) throws Exception {
    Enumeration<JarEntry> entries = jarFile.entries();
    while (entries.hasMoreElements()) {
        JarEntry entry = entries.nextElement();

        String entryName = entry.getName();
        if (entryName.endsWith(".class")) {
            ClassNode classNode = new ClassNode();

            InputStream classFileInputStream = jarFile.getInputStream(entry);
            try {
                ClassReader classReader = new ClassReader(classFileInputStream);
                classReader.accept(classNode, 0);
            } finally {
                classFileInputStream.close();
            }

            System.out.println(describeClass(classNode));
        }
    }
}
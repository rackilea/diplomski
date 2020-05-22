public static Map<String, Set<String>> getClassHierarchy(Path root) throws IOException {
    return Files.walk(root)
         .filter(p->Files.isRegularFile(p) && isClass(p.getFileName().toString()))
         .map(p -> getClassAndSuper(p))
         .collect(Collectors.groupingBy(Map.Entry::getValue,
                Collectors.mapping(Map.Entry::getKey, Collectors.toSet())));
}
private static boolean isClass(String fName) {
    // skip package-info and module-info
    return fName.endsWith(".class") && !fName.endsWith("-info.class");
}
private static Map.Entry<String,String> getClassAndSuper(Path p) {
    final class CV extends ClassVisitor {
        Map.Entry<String,String> result;
        public CV() {
            super(Opcodes.ASM5);
        }
        @Override
        public void visit(int version, int access,
                String name, String signature, String superName, String[] interfaces) {
            result = new AbstractMap.SimpleImmutableEntry<>(
                Type.getObjectType(name).getClassName(),
                superName!=null? Type.getObjectType(superName).getClassName(): "");
        }
    }
    try {
        final CV visitor = new CV();
        new ClassReader(Files.readAllBytes(p)).accept(visitor, ClassReader.SKIP_CODE);
        return visitor.result;
    } catch (IOException ex) {
        throw new UncheckedIOException(ex);
    }
}
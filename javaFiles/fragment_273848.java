private static Set<Class<?>> getClasses(Class<?> context)
    throws IOException, URISyntaxException {

    ClassLoader cll = context.getClassLoader();

    URI clURI = context.getResource(context.getSimpleName()+".class").toURI();
    if(!clURI.getScheme().equals("file")) try {
        FileSystems.getFileSystem(clURI);
    } catch(FileSystemNotFoundException ex) {
        FileSystems.newFileSystem(clURI, Collections.emptyMap());
    }
    String pkg=context.getPackage().getName();
    return Files.list(Paths.get(clURI).getParent())
        .map(p->p.getFileName().toString())
        .filter(s->s.endsWith(".class"))
        .map(s->s.substring(0, s.length()-6))
        .map(s-> { try {
            return Class.forName(pkg+'.'+s, false, cll);
          } catch(ClassNotFoundException ex) { return null; } })
        .filter(Objects::nonNull)
        .collect(Collectors.toSet());
}
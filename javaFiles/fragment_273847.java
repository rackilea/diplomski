private static Set<Class<?>> getClasses(String pkg)
  throws IOException, URISyntaxException {
    ClassLoader cll = Thread.currentThread().getContextClassLoader();

    URI clURI = cll.getResource(pkg.replace('.', '/')).toURI();
    if(!clURI.getScheme().equals("file")) try {
        FileSystems.getFileSystem(clURI);
    } catch(FileSystemNotFoundException ex) {
        FileSystems.newFileSystem(clURI, Collections.emptyMap());
    }
    return Files.list(Paths.get(clURI))
        .map(p->p.getFileName().toString())
        .filter(s->s.endsWith(".class"))
        .map(s->s.substring(0, s.length()-6))
        .map(s-> { try {
            return cll.loadClass(pkg+'.'+s);
          } catch(ClassNotFoundException ex) { return null; } })
        .filter(Objects::nonNull)
        .collect(Collectors.toSet());
}
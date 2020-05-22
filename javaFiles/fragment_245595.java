public static Map<String, Set<String>> getClassHierarchy(Class<?> context)
                                        throws IOException, URISyntaxException {
    Path p;
    URI clURI = context.getResource(context.getSimpleName()+".class").toURI();
    if(clURI.getScheme().equals("jrt")) p = Paths.get(URI.create("jrt:/modules"));
    else {
        if(!clURI.getScheme().equals("file")) try {
            FileSystems.getFileSystem(clURI);
        } catch(FileSystemNotFoundException ex) {
            FileSystems.newFileSystem(clURI, Collections.emptyMap());
        }
        String qn = context.getName();
        p = Paths.get(clURI).getParent();
        for(int ix = qn.indexOf('.'); ix>0; ix = qn.indexOf('.', ix+1)) p = p.getParent();
    }
    return getClassHierarchy(p);
}
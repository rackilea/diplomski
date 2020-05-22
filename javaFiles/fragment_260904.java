public static List<InputStream> loadResources(
        final String name, final ClassLoader classLoader) throws IOException {
    final List<InputStream> list = new ArrayList<InputStream>();
    final Enumeration<URL> systemResources = 
            (classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader)
            .getResources(name);
    while (systemResources.hasMoreElements()) {
        list.add(systemResources.nextElement().openStream());
    }
    return list;
}
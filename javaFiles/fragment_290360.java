class Tools {
    public static InputStream getResourceAsStream(String resource)
        throws FileNotFoundException
         {
        String stripped = resource.startsWith("/") ? resource.substring(1) : resource;
        InputStream stream = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader != null) {
          stream = classLoader.getResourceAsStream(stripped);
        }
        if (stream == null) {
          stream = Tools.class.getResourceAsStream(resource);
        }
        if (stream == null) {
          stream = Tools.class.getClassLoader().getResourceAsStream(stripped);
        }
        if (stream == null) {
          throw new FileNotFoundException("Resource not found: " + resource);
        }
        return stream;
    }
}
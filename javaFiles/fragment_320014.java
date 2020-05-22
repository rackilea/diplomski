public static ResourceBundle getBundle(String basePath, String baseName) throws MalformedURLException {
    File file = new File(basePath);
    URL[] urls = {file.toURI().toURL()};
    ClassLoader loader = new URLClassLoader(urls);
    ResourceBundle rb = ResourceBundle.getBundle(baseName, Locale.getDefault(), loader);
    return rb;
}
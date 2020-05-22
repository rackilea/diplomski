ClassLoader classLoader = Config.class.getClassLoader();
// or use:
// ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
// depending on what's appropriate in your case.
Enumeration<URL> roots = classLoader.getResources(".");
while (roots.hasMoreElements()) {
    final URL url = roots.nextElement();
    System.out.println(url);
}
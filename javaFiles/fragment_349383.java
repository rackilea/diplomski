ClassLoader classloader = ClassLoader.getSystemClassLoader();

URL[] urls = ((URLClassLoader) classloader).getURLs();

for (URL url : urls) {
    System.out.println(url.getFile());
}
public static List<Class> listClassesInPackage(String jarName, String packageName) throws IOException {
    packageName = packageName.replaceAll("\\.", "/");
    JarInputStream jarFile = new JarInputStream(new FileInputStream(jarName));
    JarEntry jarEntry = null;
    List<Class> classes = new ArrayList();
    do {
        try {
            jarEntry = jarFile.getNextJarEntry();
            if (jarEntry != null && jarEntry.getName().startsWith(packageName) && jarEntry.getName().endsWith(".class")) {
                Class<?> forName = Class.forName(jarEntry.getName().replaceAll("/", "\\.").replaceAll(".class", ""));
                XmlRootElement xmlAnnotation = forName.getAnnotation(XmlRootElement.class);
                if (xmlAnnotation != null) {
                    classes.add(forName);
                }
            }
        } catch (ClassNotFoundException | IOException ex) {
            // ignore this class
        }
    } while (jarEntry != null);
    return classes;
}
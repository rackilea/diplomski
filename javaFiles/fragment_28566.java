public static void main(String[] args) throws Exception {
    List<Class<Driver>> drivers = findClassesImplementing(Driver.class);
    System.out.println(drivers);
}        

public static <T extends Object> List<Class<T>> findClassesImplementing(Class<T> cls) throws IOException {
    List<Class<T>> classes = new ArrayList<Class<T>>();

    for (URL root : Collections.list(Thread.currentThread().getContextClassLoader().getResources(""))) {
        for (File file : findFiles(new File(root.getFile()), ".+\\.jar$")) {
            JarFile jarFile = new JarFile(file);
            for (JarEntry jarEntry : Collections.list(jarFile.entries())) {
                String name = jarEntry.getName();
                if (name.endsWith(".class")) try {
                    Class<?> found = Class.forName(name.replace("/", ".").replaceAll("\\.class$", ""));
                    if (cls.isAssignableFrom(found)) {
                        classes.add((Class<T>) found);
                    }
                } catch (Throwable ignore) {
                    // No real class file, or JAR not in classpath, or missing links.
                }
            }
        }
    }

    return classes;
}

public static List<File> findFiles(File directory, final String pattern) throws IOException {
    File[] files = directory.listFiles(new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory() || file.getName().matches(pattern);
        }
    });

    List<File> found = new ArrayList<File>(files.length);

    for (File file : files) {
        if (file.isDirectory()) {
            found.addAll(findFiles(file, pattern));
        } else {
            found.add(file);
        }
    }

    return found;
}
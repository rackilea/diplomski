File file = new File("/tmp/test.jar");
URLClassLoader loader = new URLClassLoader(
        new URL[]{file.toURI().toURL()}
);

String className = new JarFile(file)
        .getManifest()
        .getMainAttributes()
        .getValue(Attributes.Name.MAIN_CLASS);

Method main = loader
        .loadClass(className)
        .getDeclaredMethod("main", String[].class);

Object arg = new String[]{"1", "20"};

try {
    main.invoke(null, arg);
} catch (Exception e) {
    // do appropriate exception handling here
    e.printStackTrace(System.err);
}
private String invokeClass(String className) throws URISyntaxException, IOException, ReflectiveOperationException {
    Class<?> clazz = Class.forName(className);
    // Alternatively, you can load the new class with a new Classloader, if you don't want to pollute the current Classloader
    // Class<?> clazz = new URLClassLoader(new URL[]{getClass().getClassLoader().getResource("").toURI().toURL()}, getClass().getClassLoader()).loadClass(className);
    Method main = clazz.getDeclaredMethod("main", String[].class);
    try ( ByteArrayOutputStream out = new ByteArrayOutputStream();
          PrintStream ps = new PrintStream(out)) {
        System.setOut(ps);
        main.invoke(main, new Object[]{new String[0]});
        return out.toString();
    }
    finally {
        // Reset to the console
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
}
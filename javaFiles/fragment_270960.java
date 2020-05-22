private static final String CLASS_FOLDER =
        "/Users/juneyoungoh/Downloads/";

private static Class getClassFromFile(String fullClassName) throws Exception {
    URLClassLoader loader = new URLClassLoader(new URL[] {
            new URL("file://" + CLASS_FOLDER)
    });
    return loader.loadClass(fullClassName);
}

public static void main( String[] args ) throws Exception {
    System.out.println((getClassFromFile("ClassFile"));
}
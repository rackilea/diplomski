// Create a File object on the root of the directory containing the class file
File file = new File("c:\\myclasses\\");

try {
    // Convert File to a URL
    URL url = file.toURI().toURL();          // file:/c:/myclasses/
    URL[] urls = new URL[]{url};

    // Create a new class loader with the directory
    ClassLoader cl = new URLClassLoader(urls);

    // Load in the class; MyClass.class should be located in
    // the directory file:/c:/myclasses/com/mycompany
    Class cls = cl.loadClass("com.mycompany.MyClass");
} catch (MalformedURLException e) {
} catch (ClassNotFoundException e) {
}
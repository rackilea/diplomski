public class Example {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String jarPath = "C:\\example.jar";
        File jarFile = new File(jarPath);   
        URL[] jarUrl = new URL[1];
        jarUrl[0] = jarFile.toURI().toURL();
        URLClassLoader classLoader = new URLClassLoader (jarUrl, Example.class.getClassLoader());
        Class classToLoad = Class.forName ("DataGenerator", true, classLoader);
        classLoader.close();
        Files.delete(FileSystems.getDefault().getPath(jarPath)); 
    }
}
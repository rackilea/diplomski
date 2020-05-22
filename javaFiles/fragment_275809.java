public class Loader {
    public Object loadClass(String path, String classname) {
        File file = new File(path);
        try {
            URL classUrl = file.toURI().toURL();
            URL[] urls = new URL[]{classUrl};
            ClassLoader ucl = new URLClassLoader(urls, getClass().getClassLoader());
            return ucl.loadClass(classname);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
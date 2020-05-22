package cruft;

/**
 * ClassLoaderDemo
 * @author Michael
 * @since 2/9/12 7:09 PM
 * @link http://stackoverflow.com/questions/9220887/java-how-to-load-classes-out-of-a-jar-in-the-classpath-with-the-system-classload
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
            if (classLoader != null) {
                Class clazz = classLoader.loadClass("org.jdom.Document");
                System.out.println(clazz.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
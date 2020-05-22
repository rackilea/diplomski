import java.lang.reflect.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        URL childAndParentClassesLocation = new URL("c:/Somewhere/On/Your/Disk");
        ClassLoader cl1 = new URLClassLoader(new URL[] { childAndParentClassesLocation }, Main.class.getClassLoader());
        ClassLoader cl2 = new URLClassLoader(new URL[] { childAndParentClassesLocation }, Main.class.getClassLoader());

        Class child1 = cl1.loadClass("packagename.Child1");
        Class child2 = cl2.loadClass("packagename.Child2");

        Method child1Run = child1.getMethod("run");
        Method child2Run = child2.getMethod("run");

        child1Run.invoke(null); // Invoke run method on Child1
        child2Run.invoke(null); // Invoke run method on Child2
    }
}
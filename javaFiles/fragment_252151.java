import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Compiler {

    public static void main(String[] args) throws Exception {
        // compile the java file
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "D:\\development\\snippets\\Test.java");
        System.out.println("compiler result " + result);

        // load the new class
        File classesDir = new File("D:\\development\\snippets\\");
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { classesDir.toURI().toURL() });
        Class<?> cls = Class.forName("Test", true, classLoader);

        // invoke a method of the class via reflection
        Object instance =  cls.getDeclaredConstructors()[0].newInstance();
        Method testMethod = cls.getMethod("test");
        String testMethodResult = (String) testMethod.invoke(instance);
        System.out.println(testMethodResult);
    }
}
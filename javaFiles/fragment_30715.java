import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class ClassFinder
{
    public static void main(String[] args) throws IOException
    {
    Collection<Class<?>> classes = new ArrayList<Class<?>>();

    JarFile jar = new JarFile("/home/nono/yamts/yamts.jar");
    for (Enumeration<JarEntry> entries = jar.entries() ; entries.hasMoreElements() ;)
    {
        JarEntry entry = entries.nextElement();
        String file = entry.getName();
        if (file.endsWith(".class"))
        {
            String classname = file.replace('/', '.').substring(0, file.length() - 6);
            try 
            {
                Class<?> c = Class.forName(classname);
                classes.add(c);
            }
            catch (Throwable e) 
            {
                System.out.println("WARNING: failed to instantiate " + classname + " from " + file);
            }
        }
    }

    for (Class<?> c : classes)
        System.out.println(c);
    }
}
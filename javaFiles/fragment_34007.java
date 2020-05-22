import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

public final class BcelTest
{
    public static void main(String[] args)
    {
        JarFile jar = null;
        try
        {
            String jarName = "C:/theFile.jar";
            jar = new JarFile(jarName);
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements())
            {
                JarEntry entry = entries.nextElement();
                if (!entry.getName().endsWith(".class"))
                {
                    continue;
                }

                ClassParser parser = 
                    new ClassParser(jarName, entry.getName());
                JavaClass javaClass = parser.parse();

                System.out.println("Class: "+javaClass.getClassName());
                System.out.println("  Fields:");
                for (Field field : javaClass.getFields())
                {
                    System.out.println("    "+field);
                }
                System.out.println("  Methods:");
                for (Method method : javaClass.getMethods())
                {
                    System.out.println("    "+method);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (jar != null)
            {
                try
                {
                    jar.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
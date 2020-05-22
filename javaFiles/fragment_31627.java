package example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class XMain {

    public static void main(String[] args) throws IOException {
        Manifest manifest = new Manifest();
        manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
        manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, YMain.class.getName());
        JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream("/tmp/y.jar"), manifest);

        // Add the main class
        addClass(YMain.class, jarOutputStream);

        // Add the Util class; Y uses it to read our secret message
        addClass(Util.class, jarOutputStream);

        // Add a secret message
        jarOutputStream.putNextEntry(new JarEntry("fromx.txt"));
        jarOutputStream.write("Hello darling Y!".getBytes());
        jarOutputStream.closeEntry();

        jarOutputStream.close();
    }

    private static void addClass(Class c, JarOutputStream jarOutputStream) throws IOException
    {
        String path = c.getName().replace('.', '/') + ".class";
        jarOutputStream.putNextEntry(new JarEntry(path));
        jarOutputStream.write(Util.toByteArray(c.getClassLoader().getResourceAsStream(path)));
        jarOutputStream.closeEntry();
    }
}
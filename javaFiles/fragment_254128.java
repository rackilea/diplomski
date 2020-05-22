package tests.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;

public class CustomClassLoader extends ClassLoader {

    private File classesDir;

    public CustomClassLoader(ClassLoader parent, File classesDir) {
       super(parent);      

       this.classesDir = classesDir;
    }

    public Class findClass(String name) {
       byte[] data = loadDataFromAny(name);
       return defineClass(name, data, 0, data.length);
    }

    private byte[] loadDataFromAny(String name) {

        name = name.replace('.', '/');
        name = name + ".class";

        byte[] ret = null;

        try {
            File f = new File(classesDir.getAbsolutePath(), name);
            FileInputStream fis = new FileInputStream(f);

            ByteBuffer bb = ByteBuffer.allocate(4*1024); 
            byte[] buf = new byte[1024];
            int readedBytes = -1; 

            while ((readedBytes = fis.read(buf)) != -1) {
                bb.put(buf, 0, readedBytes);
            }

            ret = bb.array();           
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }
}
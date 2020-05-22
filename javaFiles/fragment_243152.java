import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Test {

public static void main(String[] args) throws IOException {
  String classFilePath = "/com/mysql/jdbc/AuthenticationPlugin.class";
  String jarFilePath = "D:/jars/mysql-connector-java-5.1.34.jar";     
  Test test=new Test();
  Date date = test.getLastUpdatedTime(jarFilePath, classFilePath);
  System.out.println("getLastModificationDate returned: " + date);
 }

/**
 * Returns last update time of a class file inside a jar file 
 * @param jarFilePath - path of jar file
 * @param classFilePath - path of class file inside the jar file with leading slash
 * @return 
 */
public Date getLastUpdatedTime(String jarFilePath, String classFilePath) {
JarFile jar = null;
try {
    jar = new JarFile(jarFilePath);
    Enumeration<JarEntry> enumEntries = jar.entries();
    while (enumEntries.hasMoreElements()) {
        JarEntry file = (JarEntry) enumEntries.nextElement();
        if (file.getName().equals(classFilePath.substring(1))) {
            long time=file.getTime();
            return time==-1?null: new Date(time);
        }

    }
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (jar != null) {
        try {
            jar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }
 return null;

  }

 }
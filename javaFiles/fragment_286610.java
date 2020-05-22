import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/** @see http://stackoverflow.com/questions/5587656 */
public class Verify {

    public static void main(String[] args) throws IOException {
        System.out.println(verify(new JarFile(args[0])));
    }

    private static boolean verify(JarFile jar) throws IOException {
        Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            InputStream is = null;
            byte buffer[] = new byte[8192];
            try {
                is = jar.getInputStream(entry);
                int n;
                while ((n = is.read(buffer, 0, buffer.length)) != -1) {
                }
            } catch (SecurityException se) {
                return false;
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }
        return true;
    }
}
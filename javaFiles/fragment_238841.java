import java.io.File;
import java.io.IOException;

/**
 *
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        extractExeFiles("C://Temp");

    }


    /**
     * Gets running jar file path.
     * @return running jar file path.
     */
    private static File getCurrentJarFilePath() {
        return new File(TestClass.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    }

    /**
     * Extracts all exe files to the destination directory.
     * @param destDir destination directory.
     * @throws IOException if there's an i/o problem.
     */
    private static void extractExeFiles(String destDir) throws IOException {
        java.util.jar.JarFile jar = new java.util.jar.JarFile(getCurrentJarFilePath());
        java.util.Enumeration enumEntries = jar.entries();
        String entryName;
        while (enumEntries.hasMoreElements()) {
            java.util.jar.JarEntry file = (java.util.jar.JarEntry) enumEntries.nextElement();
            entryName = file.getName();
            if ( (entryName != null) && (entryName.endsWith(".exe"))) {
                java.io.File f = new java.io.File(destDir + java.io.File.separator + entryName);
                if (file.isDirectory()) { // if its a directory, create it
                    f.mkdir();
                    continue;
                }
                java.io.InputStream is = jar.getInputStream(file); // get the input stream
                java.io.FileOutputStream fos = new java.io.FileOutputStream(f);
                while (is.available() > 0) {  // write contents of 'is' to 'fos'
                    fos.write(is.read());
                }

                fos.close();
                is.close();                
            }
        }
    }
}
package readzipfilefromjar;

import java.lang.Class;
import java.net.URL;
import java.io.InputStream;
import java.util.zip.ZipInputStream; 
import java.util.zip.ZipEntry; 
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * @author Charles
 * 
 * unzips zip file contained in jar 
 */
public class ReadZipFileFromJar {

    public static void main(String[] args) {
        (new UnZip()).unzip("SampleText.zip");
    }    
}

class UnZip {

    void unzip(String zipFileNameStr) {

        final int BUFFER = 2048;
        Class myClass = this.getClass();   
        InputStream inStream = myClass.getResourceAsStream(zipFileNameStr);       
        ZipInputStream zis = new ZipInputStream(inStream);
        ZipEntry ze; 
        try {
            BufferedOutputStream dest;
            while( (ze = zis.getNextEntry()) != null) {
               System.out.println("Extracting: " + ze);
               int count;
               byte data[] = new byte [BUFFER];
               // write the current file to the disk
               FileOutputStream fos = new FileOutputStream(ze.getName());
               dest = new BufferedOutputStream(fos, BUFFER);
               while ((count = zis.read(data, 0, BUFFER)) != -1) {
                   dest.write(data, 0, count);
               }
               dest.flush();
               dest.close();
            }
            zis.close();
        }
        catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }
}
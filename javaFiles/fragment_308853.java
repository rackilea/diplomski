import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

public class test {
    public static void main(String[] args) throws IOException {
        ZipFile zipFile = new ZipFile("test.zip");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        System.out.println(entries);

        while(entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            System.out.println(entry.getName());
            if(entry.getName().contains("java")){
                InputStream stream = zipFile.getInputStream(entry);
                System.out.println(IOUtils.toString(stream, StandardCharsets.UTF_8));
            }
        }
    }
}
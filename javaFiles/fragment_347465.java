import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SaXSample {

    public static void main(String[] args) {
        new SaXSample().run();
    }

    public void run() {

        System.out.println("This class is located under: "+getAbsolutePath());

        // using absolut pathd
        String absolutPath = "D:\\temp\\Oki.xml";
        File f = new File(absolutPath);
        System.out.println("Does the file exist using the absolut path? -> "+f.exists());
        runSaX(absolutPath);

        // using relative path (i dont know why it knows which drive C:/, D:/ to take but my .class is running from the same drive as the .xml is in)
        String relativePath = "\\temp\\Oki.xml";
        File f2 = new File(relativePath);
        System.out.println("Does the file exist using the relative path? -> "+f2.exists());
        runSaX(relativePath);

        // using a "wrong" relative path:
        String wrongRelativePath = "\\\\temp\\Oki.xml";
        File f3 = new File(wrongRelativePath);
        System.out.println("File relative path: "+f3.getPath()+" , File absolut path: "+f3.getAbsolutePath());
        runSaX(wrongRelativePath);
    }

    private void runSaX(String path) {
        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            parser.parse(path);
            System.out.println(path + " is well-formed.");
        } catch (SAXException e) {
            System.out.println(path + " is not well-formed.");
        } catch (IOException e) {
            System.out
                    .println("Due to an IOException, the parser could not check "
                            + path);
        }
    }

    private String getAbsolutePath() {
        java.security.ProtectionDomain pd = SaXSample.class
                .getProtectionDomain();
        if (pd == null)
            return null;
        java.security.CodeSource cs = pd.getCodeSource();
        if (cs == null)
            return null;
        java.net.URL url = cs.getLocation();
        if (url == null)
            return null;
        java.io.File f = new File(url.getFile());
        if (f == null)
            return null;

        return f.getAbsolutePath();
    }

}
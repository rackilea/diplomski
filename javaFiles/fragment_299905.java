import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class StaxDemo {

// This method reads manifest data from a JAR file and shows its information
public static void main(String[] args) {
    Enumeration resourcesEnum;
    try {
        resourcesEnum = Thread.currentThread().getContextClassLoader().
                        getResources(JarFile.MANIFEST_NAME);
        while (resourcesEnum.hasMoreElements()) {
            try {
                URL url = (URL) resourcesEnum.nextElement();                    
                if (url.toString().contains("stax2-api-3.0.1.jar")) {
                    InputStream inputStream = url.openStream();
                    if (inputStream != null) {
                        Manifest manifest = new Manifest(inputStream);
                        Attributes mainAttribs = manifest.getMainAttributes();
                        String specificationVersion = 
                        mainAttribs.getValue("Specification-Version");
                        String implementationVersion = 
                        mainAttribs.getValue("Implementation-Version");
                        if (specificationVersion != null && implementationVersion != 
                            null) {
                            System.out.println("Specification Version : " + 
                                                specificationVersion);
                            System.out.println("Implementation Version : " + 
                                                implementationVersion);
                        }
                    }
                }
            } catch (Exception e) {
                // handle
            }
        }
    } catch (IOException e1) {
        // handle
    }
}
import java.io.FileInputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("test.properties"));
        System.out.println(properties.getProperty("ReferenceDataLocation"));
        System.out.println(properties.getProperty("LicenseKey"));
        System.out.println(properties.getProperty("foo"));
    }
}
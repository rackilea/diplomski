import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyTest {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML( new FileInputStream("properties.xml") );

        System.out.println( properties.getProperty("Property With Spaces") );
        System.out.println( properties.getProperty("PropertyWithoutSpaces") );
    }

}
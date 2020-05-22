import java.util.Properties;

public class LoadProperties {
    public static void main( String [] args ) throws java.io.IOException {
        Properties properties = new Properties();
        properties.load( LoadProperties.class.getResourceAsStream("connection.properties"));
        properties.list( System.out );
    }
}
import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main( String [] args ) {
        ResourceBundle bundle = ResourceBundle.getBundle("connection");
        for( String key: bundle.keySet() ){
            System.out.printf("bundle[%s]=%s%n",key, bundle.getString(key));
        }
    }
}
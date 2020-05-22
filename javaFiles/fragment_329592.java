public class PropertyTest {

public static Properties properties = new Properties();

private static void loadProperties() {
    FileInputStream fis;
    try {
        fis = new FileInputStream("src/test/resources/property/android.properties");
        properties.load(fis);
        fis.close();
    } catch (FileNotFoundException e) {

    } catch (IOException e) {

    }
} 
public static String getProperty(String key) {
    String value = "";
    if (key != "") {
        loadProperties();
        try {
            if (!properties.getProperty(key).trim().isEmpty())
                value = properties.getProperty(key).trim();
        }

        catch (NullPointerException e) {

        }
    }

    return value;
}       

}
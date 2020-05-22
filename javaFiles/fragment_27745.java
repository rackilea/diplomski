public class PropertyFileTest {
    public void loadProperties() {
        InputStream inputStream = PropertyFileTest.class.getResourceAsStream("/demo.properties");

        properties.load(inputStream);
        // do something with properties to see if it worked or not.
    }
}
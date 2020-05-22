public class ReadPropertyFile {
    private String gateway;

    public ReadPropertyFile() {
        setValue();

    }

    public void setValue(){
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("config.properties")) {

            // load a properties file
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // get the property value and print it out
        gateway = prop.getProperty("gateway");

    }

    public String getGateway() {
        return this.gateway;
    }
}
public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private final static String PROPERTY_PREFIX = "{SPECIAL}";

    protected Properties properties;

    @Override
    protected void convertProperties(Properties props) {
        this.properties = props;
        super.convertProperties(props);
    }

    @Override
    public String convertPropertyValue(String originalValue) {
        if (originalValue.startsWith(PROPERTY_PREFIX)) {
            return convert(originalValue.substring(PROPERTY_PREFIX.length()));
        }
        return originalValue;
    }

    protected String convert(String value){
        // access properties from config.properties
        String pw = this.properties.getProperty("password");
        // use properties and do what you need to do
        return value + pw;
    }

}
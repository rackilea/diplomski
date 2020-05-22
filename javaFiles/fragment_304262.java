public class PropertiesManager {
    ...
    public String getProperty(EnumProp enumProp) {
        return properties.getProperty(enumProp.getKey(), enumProp.getDefaultValue());
    }

    public void setProperty(EnumProp enumProp, String value) {
        properties.setProperty(enumProp.getKey(), value);
    }
}
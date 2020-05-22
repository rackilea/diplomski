public class SomeClass {

    @JsonDeserialize(using = CustomPropertyDeserializer.class)
    private Properties property;

    public Properties getProperty() {
        return property;
    }

    public void setProperty(Properties property) {
        this.property = property;
    }
}
@Configuration
@ConfigurationProperties
public class SomePropertyConfig {

    //name of the property from application.properties
    private String someProperty;

    public String getSomeProperty() {
        return someProperty;
    }

    public void setSomeProperty(String someProperty) {
        this.someProperty = someProperty;
    }
}
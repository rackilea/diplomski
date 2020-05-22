@Configuration
@ConfigurationProperties(prefix="test", locations = "classpath:SettingsTest.properties")
public class TestSettings {

    private String property;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
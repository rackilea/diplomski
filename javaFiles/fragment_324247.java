@Configuration
@ConfigurationProperties("example-unit")
public class ConfigurationUnit {

public List<String> confiList;

public List<String> getConfiList() {
    return this.confiList;
    }

 }
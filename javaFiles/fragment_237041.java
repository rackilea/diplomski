@Configuration
@ConfigurationProperties
public class MyConfig {

    private final Map<String, Project> myConfig = new HashMap<>();

    public Map<String, Project> getMyConfig() {
        return myConfig;
    }

    public static class Project {

        private String mantisID;
        private String password;
        private String user;

        // Getters and setters...
    }
}
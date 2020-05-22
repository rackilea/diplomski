@ConfigurationProperties(prefix = "sample.db")
public class DbProperties {
    private String serverName;
    private String serverPort;
    private String databaseName;

    // getters and setters
}
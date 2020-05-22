@ConfigurationProperties
public class DatabaseProperties {

    private Connection primaryConnection;

    private Connection backupConnection;

    // getter, setter ...

    public static class Connection {

        private String host;

        // getter, setter ...

    }

}
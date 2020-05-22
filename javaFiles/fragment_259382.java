@ConfigurationProperties
public class DatabaseProperties {

    @NestedConfigurationProperty
    private Connection primaryConnection; // Connection is defined somewhere else

    @NestedConfigurationProperty
    private Connection backupConnection;

    // getter, setter ...

}
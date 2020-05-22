@EnableConfigurationProperties
public class AppConfig {
}

@ConfigurationProperties("app.constants")
public class AppProperties {
    private String name;        // = ${app.constants.name}
    private String version;     // = ${app.constants.version}
    private int port;           // = ${app.constants.port}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
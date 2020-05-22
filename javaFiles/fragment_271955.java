@ConfigurationProperties(prefix = "spring.activemq")
public class ActiveMQProperties {

    private String brokerUrl = "tcp://localhost:61616";

    private boolean inMemory = true;

    private boolean pooled = false;

    private String user;

    private String password;

    // Will override brokerURL if inMemory is set to true
    public String getBrokerUrl() {
        if (this.inMemory) {
            return "vm://localhost";
        }
        return this.brokerUrl;
    }

    public void setBrokerUrl(String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }

    public boolean isInMemory() {
        return this.inMemory;
    }

    public void setInMemory(boolean inMemory) {
        this.inMemory = inMemory;
    }

    public boolean isPooled() {
        return this.pooled;
    }

    public void setPooled(boolean pooled) {
        this.pooled = pooled;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
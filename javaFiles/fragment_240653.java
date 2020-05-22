public class ServiceFacade {
    private String endpoint;

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void doStuffWithWebService() {
        // use the value of endpoint to construct client
    }
}
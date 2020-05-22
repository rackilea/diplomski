class ServiceOperations {
    @Inject
    public ServiceOperations(Client client) {
        this.client = client;
    }

    public String getData() {
        return client.getData();
    }
}
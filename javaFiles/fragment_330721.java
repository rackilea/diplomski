public final RestClients {
    private final ServiceLoader<RestClient> restClients = ServiceLoader.load(RestClient.class);

    public RestClient getClient(RestClientSpec spec) throws NoClientFoundForSpecException {
        for (RestClient client : restClients) {
            if (/* client matches your specification */) {
                return client;
            }
        }
        throw new NoClientFoundForSpecException(spec);
    }
}
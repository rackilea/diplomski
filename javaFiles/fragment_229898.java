protected Client createClient() {
        HttpClient httpClient = new HttpClient();
        ApacheHttpClientConfig config = new DefaultApacheHttpClientConfig();
        config.getProperties().put(ApacheHttpClientConfig.PROPERTY_HANDLE_COOKIES, true);
        // ApacheHttpClient httpClient = ApacheHttpClient.create(config);
        ApacheHttpClientHandler clientHandler = new ApacheHttpClientHandler(httpClient, config);
        ClientHandler root = new ApacheHttpClient(clientHandler);

        Client client = new Client(root, config);
        return client;
}
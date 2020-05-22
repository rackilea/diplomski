public T create(Class<T> resourceType) throws Exception {
    T resource = JAXRSClientFactory.create(basePath, resourceType, username, password, null);
    Client client = WebClient.client(resource);
    WebClient webClient = WebClient.fromClient(client);
    SSLUtil.configure(webClient);
    return resource;
}
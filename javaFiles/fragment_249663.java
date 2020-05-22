import org.glassfish.jersey.client.ClientProperties;

ClientConfig configuration = new ClientConfig();
configuration.property(ClientProperties.CONNECT_TIMEOUT, 1000);
configuration.property(ClientProperties.READ_TIMEOUT, 1000);
Client client = ClientBuilder.newClient(configuration);
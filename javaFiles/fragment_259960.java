public static void main(String[] args) {
    Client client = ClientBuilder.newClient();

    client.property(ClientProperties.CONNECT_TIMEOUT, 1000);
    client.property(ClientProperties.READ_TIMEOUT,    1000);

    WebTarget target = client.target("http://1.2.3.4:8080");

    try {
        String responseMsg = target.path("application.wadl").request().get(String.class);
        System.out.println("responseMsg: " + responseMsg);
    } catch (ProcessingException pe) {
        pe.printStackTrace();
    }
}
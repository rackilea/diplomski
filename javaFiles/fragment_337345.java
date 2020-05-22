@Test
public void testResteasy() {
    WebTarget target = client.target(TestPortProvider.generateURL(BASE_URI))
            .path("messages").path("1234").path("comments").path("5678");
    Response response = target.request().get();
    System.out.println("Status:" + response.getStatus());
    System.out.println("Response: " + response.readEntity(String.class));
    response.close();
}
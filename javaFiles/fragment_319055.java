public void testMyResource() throws Exception {
    ClientConfig config = new DefaultClientConfig();
    config.getClasses().add(JacksonJsonProvider.class);
    config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, 
                                                       Boolean.TRUE);

    Client c = Client.create(config);

    WebResource resource = c.resource(Main.BASE_URI).path("properties");
    String json = resource.accept("application/json").get(String.class);
    System.out.println(json);

    FileInputStream fis = new FileInputStream("test.properties");
    Properties props = new Properties();
    props.load(fis);
    String postResponse 
            = resource.type("application/json").post(String.class, props);
    System.out.println(postResponse);
}
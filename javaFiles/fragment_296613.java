ClientConfig config = new DefaultClientConfig();
config.getClasses().add(MultiPartWriter.class);     
Client client = Client.create(config);

WebResource resource = client.resource(
            "http://localhost:8080/url/url11/upload");

InputStream is = App.class.getClassLoader().getResourceAsStream("aa10.csv");
String exampleString = "{\"accessToken\":\"324d393c-f564-4699- ae53-8fdcfc7b8fe6\",\"serverName\":\"SIT\",\"appPlatform\":\"UNKNOWN\",\"appBundleId\":\"com.\"}";
InputStream stream = new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8));

FileDataBodyPart filePart = new FileDataBodyPart("file",
            new File("/Users/user/Documents/aa10.csv"));

FormDataMultiPart multipartEntity = (FormDataMultiPart) new FormDataMultiPart()
            .field("model", exampleString, MediaType.MULTIPART_FORM_DATA_TYPE).bodyPart(filePart);

ClientResponse response = resource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class,
            multipartEntity);
Client client = ClientBuilder.newBuilder()
        .register(MultiPartFeature.class)
        .build();

MultiPart multiPart = new FormDataMultiPart()
        .field("items", "[\"Apple\", \"Orang\"]", MediaType.APPLICATION_JSON_TYPE)
        .bodyPart(new FileDataBodyPart("photo", new File("img.png"));

Response response = client
        .target(url)
        .request()
        .header(HttpHeaders.CACHE_CONTROL, "no-cache")
        .post(Entity.entity(multiPart), multiPart.getMediaType());
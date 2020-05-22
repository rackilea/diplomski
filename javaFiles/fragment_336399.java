public class Slimclient {
    private static final String TARGET_URL = "http://localhost:49158/rest/service/upload";

    public Slimclient() {
        Client client = ClientBuilder.newBuilder()
            .register(MultiPartFeature.class).build();
        WebTarget webTarget = client.target(TARGET_URL);
        MultiPart multiPart = new MultiPart();
        multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);

        FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("file",
            new File("C:/Users/Nicklas/Desktop/aab.txt"),
            MediaType.APPLICATION_OCTET_STREAM_TYPE);
        multiPart.bodyPart(fileDataBodyPart);

        Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
            .post(Entity.entity(multiPart, multiPart.getMediaType()));

        System.out.println(response.getStatus() + " "
            + response.getStatusInfo() + " " + response);
    }

    public static void main(String[] args) {
        new Slimclient();
    }
}
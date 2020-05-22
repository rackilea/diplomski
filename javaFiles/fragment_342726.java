public class Test {

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/restfullwebservice/resources/generic").build("");
    }

    public static void main(String[] args) throws FileNotFoundException {
        final ClientConfig config = new DefaultClientConfig();
        final Client client = Client.create(config);

        final WebResource resource = client.resource(getBaseURI()).path("upload");

        final File fileToUpload = new File("C:/Users/Public/Pictures/Desert.jpg");

        final FormDataMultiPart multiPart = new FormDataMultiPart();
        if (fileToUpload != null) {
            multiPart.bodyPart(new FileDataBodyPart("file", fileToUpload,
                    MediaType.APPLICATION_OCTET_STREAM_TYPE));
        }

        final ClientResponse clientResp = resource.type(
                MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class,
                multiPart);
        System.out.println("Response: " + clientResp.getClientResponseStatus());

        client.destroy();
    }
}
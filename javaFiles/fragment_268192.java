@Inject
private ComponentResources resources;

@OnEvent(value = "GET_IMAGE_STREAM_EVENT")
private Object getProfilePic() throws Exception {


    InputStream openStream = DetallesMultimedia.class.getResourceAsStream("/home/santi/Escritorio/evolution-of-mario.jpg");
    byte[] imageBytes = IOUtils.toByteArray(openStream);
    final ByteArrayInputStream output = new ByteArrayInputStream(imageBytes);

    final StreamResponse response = new StreamResponse() {

        public String getContentType() {
           "image/jpegOrPngOrGif";
        }

        public InputStream getStream() throws IOException {
            return output;
        }

        public void prepareResponse(Response response) {
            // add response headers if you need to here
        }

    };
    return response;
}

public String getPicUrl() throws Exception {
    return resources.createFormEventLink("GET_IMAGE_STREAM_EVENT");
}
public void testUploading() {
        File file = new File("C:\\your_test_file_to_upload.jpg");
        FileDataBodyPart fileDataPart = new FileDataBodyPart("file", file, MediaType.APPLICATION_OCTET_STREAM_TYPE);
        try (FormDataMultiPart formDataMultiPart = new FormDataMultiPart()) {
                MultiPart multipartEntity = formDataMultiPart.bodyPart(fileDataPart);

                Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();

                Response response = client.target("/" + PathConstants.UPLOAD_RESOURCE)
                        .request()
                        .post(Entity.entity(multipartEntity, MediaType.MULTIPART_FORM_DATA));
        }
}
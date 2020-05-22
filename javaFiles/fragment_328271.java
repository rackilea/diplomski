public void postFileMethod(String URL) throws FileNotFoundException {
    Response response = null;
    ResteasyClient client = new ResteasyClientBuilder().build();
    ResteasyWebTarget target = client.target(URL);

    MultipartFormDataOutput mdo = new MultipartFormDataOutput();
    mdo.addFormData("my_file", new FileInputStream(new File("C:/sample/sample.zip")), MediaType.APPLICATION_OCTET_STREAM_TYPE);
    GenericEntity<MultipartFormDataOutput> entity = new GenericEntity<MultipartFormDataOutput>(mdo) { };

    response = target.request().post(Entity.entity(entity,
            MediaType.MULTIPART_FORM_DATA));
}
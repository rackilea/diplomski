Response buildResponse(){
    String baseUrl = getOpenAMApiBaseUrl();
    String path = "/openam/json/authenticate";

    // Response NEEDS TO BE MOCKED SOMEHOW
    Response response = jaxClient.target(baseUrl + path)
            .request(MediaType.APPLICATION_JSON_TYPE)
            .header(HttpHeaderField.OPENAM_USERNAME, username)
            .header(HttpHeaderField.OPENAM_PASSWORD, password)
            .post(Entity.json(null));
}
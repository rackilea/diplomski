public static void main(String[] args) {

    HttpPost post = new HttpPost("http://localhost:8080/ServletExample/SampleServlet");
    MultipartEntity entity = new MultipartEntity();
    entity.addPart( "someXMLfile", new StringBody(generateNewXML(), "application/xml",
        Charset.forName( "UTF-8" )));
    post.setEntity(entity);

    HttpClient client = new DefaultHttpClient();
    HttpResponse response = client.execute(post);
}
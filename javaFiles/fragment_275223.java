public class PostClient {

    public static void main(String[] args) throws ClientProtocolException, IOException {
        HttpPost post = new HttpPost("http://localhost:8080/ServletExample/SampleServlet");
        post.setHeader("Content-Type", "application/xml");
        post.setEntity(new StringEntity("<xml></xml>"));
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(post);
    }

}
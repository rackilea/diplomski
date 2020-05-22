public static void main(String argv[]) throws Exception {
    DefaultHttpClient httpClient = new DefaultHttpClient();
    HttpPost post = new HttpPost(
            "https://www.googleapis.com/drive/v2/files");
    post.addHeader("Content-Type", "application/json");
    post.addHeader("Authorization",
            "Bearer XXXXXXXXXXXXXXXXXXXXXXXXX");

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("title", "Test folder");
    jsonObject
            .addProperty("mimeType", "application/vnd.google-apps.folder");

    post.setEntity(new StringEntity(jsonObject.toString()));
    httpClient.execute(post);
}
private final OkHttpClient client = new OkHttpClient();
  private final String url = "http://test.com";

  public void run(String token) throws Exception {
    Request request = new Request.Builder()
    .url(url)
    //This adds the token to the header.
    .addHeader("Authorization", "Bearer " + token)
    .build();
     try (Response response = client.newCall(request).execute()) {
          if (!response.isSuccessful()){
             throw new IOException("Unexpected code " + response);
          }

         System.out.println("Server: " + response.header("anykey"));

     }
  }
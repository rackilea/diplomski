public boolean isServerUp(){

    private final OkHttpClient client = new OkHttpClient();

      public void run() throws Exception {
        Request request = new Request.Builder()
            .url("your server url here")
            .build();

        client.newCall(request).enqueue(new Callback() {
          @Override public void onFailure(Call call, IOException e) {
            e.printStackTrace();
            return false;
          }

          @Override public void onResponse(Call call, Response response) throws IOException {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return true; 
          }
        });
      }
      return false;
}
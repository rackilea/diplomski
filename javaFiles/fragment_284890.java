public class Main {

  static OkHttpClient _client = new OkHttpClient();

  public static void main(String[] args) throws IOException {
      performQuery();
  }

  private static void performQuery() throws IOException {
      Request firstRequest = new Request.Builder()
            .url("http://localhost/test/index.php")
            .get()
            .build();
      Response firstResponse = _client.newCall(firstRequest).execute();

      Request.Builder requestBuilder = new Request.Builder()
            .url("http://localhost/test/index.php");

      Headers headers = firstResponse.headers();

      requestBuilder = requestBuilder.addHeader("Cookie", headers.get("Set-Cookie"));

      Request secondRequest = requestBuilder.get().build();
      Response secondResponse = _client.newCall(secondRequest).execute();
  }
}
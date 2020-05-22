OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
  .url("https://mytenant.auth0.com/userinfo")
  .get()
  .addHeader("authorization", "Bearer  {{access_token}}")
  .addHeader("cache-control", "no-cache")
  .build();

Response response = client.newCall(request).execute();
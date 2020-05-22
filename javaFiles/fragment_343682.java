static final String MESSAGE_BASE_URL = "https://api.wit.ai/message";
static final String MY_ACCESS_TOKEN = "...";

private final OkHttpClient client = new OkHttpClient();

...
HttpUrl url = HttpUrl.parse(MESSAGE_BASE_URL)
  .newBuilder()
  .addQueryParameter("q", message)
  .build();
Request request = new Request.Builder()
  .url(url)
  .addHeader("authorization", "Bearer " + MY_ACCESS_TOKEN)
  .build();
Response response = client.newCall(request).execute();
return response.body().string();
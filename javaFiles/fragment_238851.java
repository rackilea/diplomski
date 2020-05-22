OkHttpClient client = new OkHttpClient();
Request request = new Request.Builder()
    .url(url)
    .build();

Response response = client.newCall(request).execute();
String reponse = response.body().string();
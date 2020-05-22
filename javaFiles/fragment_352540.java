final OkHttpClient client = new OkHttpClient();

HttpUrl url = HttpUrl.parse("https://myUrl.com/login").newBuilder()
        .addQueryParameter("password", "123456")
        .addQueryParameter("username", "123456")
        .build();

Request request = new Request.Builder()
       .url(url)
       .build();
(...)
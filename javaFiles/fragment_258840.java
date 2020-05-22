OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url(SERVICE_URL)
            .put(RequestBody.create(MediaType.parse("application/octet-stream"), REQUEST_BODY))
            .addHeader("cache-control", "no-cache")
            .build();
    Response response = client.newCall(request).execute();
    String responseBody = response.body().string();
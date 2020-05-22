class Http {
    volatile OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true).build();

    public Response getPage(String url) {
        Request request = new Request.Builder().url(url).build();

        try {
            this.response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
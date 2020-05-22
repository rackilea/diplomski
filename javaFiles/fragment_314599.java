class Http implements Runnable {

    //initialize Http. This can be done better perhaps
    volatile OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true).build();

    private Response response;

    private String url;

    public Http(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        this.getPage(this.url);
    }

    public void getPage(String url) {
        Request request = new Request.Builder().url(url).build();

        try {
            this.response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
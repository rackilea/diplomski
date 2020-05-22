final OkHttpClient client = new OkHttpClient();
RequestBody body = new FormBody.Builder()
        .add("Token",token1)
        .build();

final okhttp3.Request request = new okhttp3.Request.Builder()
        .url("http://saleh923.byethost8.com/hii.html")
        .post(body)
        .build();

final Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
});
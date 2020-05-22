OkHttpClient client = new OkHttpClient();
        // GET request
        Request request = new Request.Builder()
                .url("http://google.com")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.e(LOG_TAG, e.toString());
            }
            @Override
            public void onResponse(Response response) throws IOException {
                Log.w(LOG_TAG, response.body().string());
                Log.i(LOG_TAG, response.toString());
            }
        });
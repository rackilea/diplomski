OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(15, TimeUnit.SECONDS)
                        .writeTimeout(15, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .build();

new AsyncTask<Void, Void, JSONArray>() {

    @Override
    protected JSONArray doInBackground(Void... voids) {
        Request request = new Request.Builder()
                            .url(url)
                            .addHeader("Authorization", authentication.getToken())
                            .addHeader("Content-Type", "application/json")
                            .addHeader("Accept", "application/json")
                            .addHeader("X-Service-Code", "PP")
                            .get()
                            .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return new JSONArray(response.body().string());
            } else {
                // notify error
            }
        } catch (IOException e) {
            // notify error e.getMessage()
        }

        return null;
    }

    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        super.onPostExecute(jsonArray);
        if (jsonArray != null && jsonArray.size() > 0) {
            // notify status using LocalBroadcastManager or EventBus
        }
    }
}.execute();
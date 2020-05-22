public void sendAPICall(final String reg_token, final  String body, final String title) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    OkHttpClient client = new OkHttpClient();
                    JSONObject json = new JSONObject();
                    JSONObject dataJson = new JSONObject();
                    dataJson.put("body", body);
                    dataJson.put("title", title);
                    json.put("notification", dataJson);
                    json.put("to", reg_token);
                    RequestBody body = RequestBody.create(JSON, json.toString());
                    Request request = new Request.Builder()
                            .header("Authorization", "key=" + Constants.GCM_AUTH_KEY)
                            .url("http://learnologic.com/send")
                            .post(body)
                            .build();
                    okhttp3.Response response = client.newCall(request).execute();
                    String finalResponse = response.body().string();
                    Logger.showDebugLog(finalResponse);
                } catch (Exception e) {
                    Logger.showErrorLog(e.toString());
                }
                return null;
            }
        }.execute();

    }
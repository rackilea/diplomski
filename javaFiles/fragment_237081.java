private String ConsumeGetRequest(String path) {
    int tries = 0;
    boolean isMyException = true;
    while (tries <= 3 && isMyException) {
        try {
            isMyException = false;
            tries++;
            Response response = executeRequestBody(path, null);
            if (response != null && response.body() != null)
                return response.body().string();
            else
                return "";

        } catch (ConnectException e) {
            e.printStackTrace();
            if (e.getMessage().contains("Failed to connect to") && tries <= 3) {
                isMyException = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
    return "";
}

private Pair<Boolean, String> ConsumePostRequest(String path, String postData) {
    int tries = 0;
    String errorMsg = null;
    boolean isMyException = true;
    //you can ignore this while, it was for our internal reasons and it's just a check.
    while (tries <= 3 && isMyException) {
        try {
            isMyException = false;
            tries++;
            Response response = executeRequestBody(path, postData);
            if (response != null && response.body() != null)
                return new Pair<>(response.isSuccessful(), response.body().string());
            else
                return new Pair<>(false, null);
        } catch (ConnectException e) {
            errorMsg = e.getMessage();
            if (e.getMessage().contains("Failed to connect to") && tries <= 3) {
                isMyException = true;
            }
        } catch (Exception ex) {
            errorMsg = ex.getMessage();
        }
    }
    return new Pair<>(false, errorMsg);
}

private Response executeRequestBody(String path, String postData) throws IOException {
    String url = String.format("%s%s/", RuntimeHelper._baseWebServiceIP, path);
    if (okHttpClient == null) {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build();
    }
    Request.Builder builder = new Request.Builder().url(url);
    if (postData != null && !postData.isEmpty()) {
        RequestBody body = RequestBody.create(RuntimeHelper._okHttpTypeJson, postData);
        builder = builder.post(body);
    }
    Request request = builder.build();

    return okHttpClient.newCall(request).execute();
}
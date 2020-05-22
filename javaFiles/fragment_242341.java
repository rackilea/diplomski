final OkHttpClient client = new OkHttpClient();

     RequestBody formBody = new FormBody.Builder()
            .add("field to be filled", "content")
            .build();
        Request request = new Request.Builder()
            .url("webpage url")
            .post(formBody)
            .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
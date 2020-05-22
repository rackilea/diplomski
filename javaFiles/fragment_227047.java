Call call = httpClient.newCall(
        new Request.Builder()
                .url(url)
                .header("Authorization", tempToken)
                .post(new FormBody.Builder()
                        // TODO user getId()
                        .add("id","")
                        .add("custom_fields", field)
                        .build())
                .build()
);
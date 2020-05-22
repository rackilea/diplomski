Request _rbuilder = new Request.Builder()
    .url(url)
    .addHeader("Content-Type",
            "application/json; charset=utf-8"
    )
    .post(multipartBodyBuilder.build())
    .build();
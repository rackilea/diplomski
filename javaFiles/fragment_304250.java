Map<String, String> jsonMapParams = objectMapper.readValue(jsonStringParams, new TypeReference<Map<String, String>>() {});

    List<NameValuePair> formParams = jsonMapParams.entrySet().stream()
            .map(e -> new BasicNameValuePair(e.getKey(), e.getValue()))
            .collect(Collectors.toList());
    HttpEntity httpEntity = new UrlEncodedFormEntity(formParams);
    ByteBuf byteBuf = Unpooled.copiedBuffer(EntityUtils.toByteArray(httpEntity));

    httpRequest.headers().set(ACCEPT_ENCODING, GZIP);
    httpRequest.headers().set(CONTENT_TYPE, "application/x-www-form-urlencoded");
    httpRequest.headers().set(CONTENT_LENGTH, byteBuf.readableBytes());
    httpRequest.content().clear().writeBytes(byteBuf);
String jwt = "";
    try {
        jwt = Jwts.builder()
                .claim("scope", "app")
                .setHeaderParam(KEY_ID, "MY_KEY_ID")
                .signWith(
                        SignatureAlgorithm.HS256,
                        "MY_SECRET".getBytes("UTF-8")
                )
                .compact();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    if (!jwt.isEmpty()) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("jwt");
        apiKeyAuth.setApiKey(jwt);
        apiKeyAuth.setApiKeyPrefix("Bearer");

        ConversationApi apiInstance = new ConversationApi();
        String userId = preferencesRepository.getUserId();
        MessagePost messagePostBody = new MessagePost();
        messagePostBody.setRole("appUser");
        messagePostBody.setType(MessagePost.TypeEnum.TEXT);
        messagePostBody.setText(message);
        messagePostBody.setItems(null);
        try {
            PostMessagesResponse result = apiInstance.postMessage(userId, messagePostBody);
            Log.d(TAG, "sendMessage: " + result);
        } catch (ApiException e) {
            Log.e(TAG, "sendMessage:", e);
        }
    }
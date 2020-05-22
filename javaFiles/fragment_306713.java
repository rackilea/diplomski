public static String shortenUrl(String longUrl)
   {
        @SuppressWarnings("unused")
        OAuthService oAuthService = new ServiceBuilder().provider(GoogleApi.class).apiKey("anonymous").apiSecret("anonymous")
                        .scope("https://www.googleapis.com/auth/urlshortener") .build();
        OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST, "https://www.googleapis.com/urlshortener/v1/url");
        oAuthRequest.addHeader("Content-Type", "application/json");
        String json = "{\"longUrl\": \"http://"+longUrl+"/\"}";
        oAuthRequest.addPayload(json);
        Response response = oAuthRequest.send();
        Type typeOfMap = new TypeToken<Map<String, String>>() {}.getType();
        Map<String, String> responseMap = new GsonBuilder().create().fromJson(response.getBody(), typeOfMap);
        String st=responseMap.get("id");
        return st;
    }
DefaultHttpClient httpClient = new DefaultHttpClient();

    HttpPost postRequest = new HttpPost(
            "https://api.stormpath.com/v1/accounts/cJoiwcorTTmkDDBsf02bAb/customData");

    String credentials = apiKey.getId() + ":" + apiKey.getSecret();
    postRequest.setHeader("Authorization", "Basic " + Base64.encodeBase64String(credentials.getBytes("UTF-8")));
    postRequest.setHeader("Accept", "application/json");

    StringEntity input = new StringEntity("{\"favoriteColor\":\"red\",\"hobby\":\"Kendo\"}");
    input.setContentType(ContentType.APPLICATION_JSON.toString());
    postRequest.setEntity(input);

    HttpResponse response = httpClient.execute(postRequest);
    System.out.println(response);
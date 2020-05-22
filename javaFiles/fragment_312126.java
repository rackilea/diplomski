private String getUserMailAddressFromJsonResponse(String accessToken, HttpSession httpSession) {

        HttpClient httpclient = new DefaultHttpClient();
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {

            if (accessToken != null && !"".equals(accessToken)) {
                json = (JSONObject) parser.parse(accessToken);
                String newUrl = "https://graph.facebook.com/me?access_token=" + json.get("access_token");
                httpclient = new DefaultHttpClient();
                HttpGet httpget = new HttpGet(newUrl);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                String responseBody = httpclient.execute(httpget, responseHandler);
...
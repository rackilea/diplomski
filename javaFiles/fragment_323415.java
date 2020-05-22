@RequestMapping(value = "/twauth", method = RequestMethod.GET)
    @ResponseBody
    public String twAuth(HttpServletResponse response) throws Exception{
        try {
            String url = "https://api.twitter.com/oauth/request_token";

            List<NameValuePair> allParams = new ArrayList<NameValuePair>();
            allParams.add(new BasicNameValuePair("oauth_callback", "http://127.0.0.1:8080/twlogin"));
            allParams.add(new BasicNameValuePair("oauth_consumer_key", "2YhNLyum1VY10UrWBMqBnatiT"));
            allParams.add(new BasicNameValuePair("oauth_signature_method", "HMAC-SHA1"));
            allParams.add(new BasicNameValuePair("oauth_version", "1.0"));

            HeaderCreator headerCreator = new HeaderCreator("RUesRE56vVWzN9VFcfA0jCBz9VkvkAmidXj8d1h2tS5EZDipSL");
            headerCreator.generatedSignature(url,"POST",allParams,false);
            allParams.add(new BasicNameValuePair("oauth_nonce", headerCreator.getoAuthNonce()));
            allParams.add(new BasicNameValuePair("oauth_signature", headerCreator.getoAuthSignature()));
            allParams.add(new BasicNameValuePair("oauth_timestamp", headerCreator.getoAuthTimestamp()));

            Map<String, String> props = new HashMap<String, String>();
            props.put("Authorization", headerCreator.generatedAuthorization(allParams));
            String twitterResponse = Requests.sendPost(url,"",props);
            Integer indOAuthToken = twitterResponse.indexOf("oauth_token");
            String oAuthToken = twitterResponse.substring(indOAuthToken, twitterResponse.indexOf("&",indOAuthToken));

            response.sendRedirect("https://api.twitter.com/oauth/authenticate?" + oAuthToken);
        }catch (Exception ex){
            //TODO: Log
            throw new Exception();
        }
        return "main";
    }
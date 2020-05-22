@RequestMapping(value = "/twlogin", method = RequestMethod.GET)
    public String twLogin(@RequestParam("oauth_token") String oauthToken,
                          @RequestParam("oauth_verifier") String oauthVerifier,
                          Model model, HttpServletRequest request){
        try {
            if(oauthToken==null || oauthToken.equals("") ||
                    oauthVerifier==null || oauthVerifier.equals(""))
                return "main";

            String url = "https://api.twitter.com/oauth/access_token";

            List<NameValuePair> allParams = new ArrayList<NameValuePair>();
            allParams.add(new BasicNameValuePair("oauth_consumer_key", "2YhNLyum1VY10UrWBMqBnatiT"));
            allParams.add(new BasicNameValuePair("oauth_signature_method", "HMAC-SHA1"));
            allParams.add(new BasicNameValuePair("oauth_token", oauthToken));
            allParams.add(new BasicNameValuePair("oauth_version", "1.0"));
            NameValuePair oAuthVerifier = new BasicNameValuePair("oauth_verifier", oauthVerifier);
            allParams.add(oAuthVerifier);

            HeaderCreator headerCreator = new HeaderCreator("RUesRE56vVWzN9VFcfA0jCBz9VkvkAmidXj8d1h2tS5EZDipSL");
            headerCreator.generatedSignature(url,"POST",allParams,false);
            allParams.add(new BasicNameValuePair("oauth_nonce", headerCreator.getoAuthNonce()));
            allParams.add(new BasicNameValuePair("oauth_signature", headerCreator.getoAuthSignature()));
            allParams.add(new BasicNameValuePair("oauth_timestamp", headerCreator.getoAuthTimestamp()));
            allParams.remove(oAuthVerifier);

            Map<String, String> props = new HashMap<String, String>();
            props.put("Authorization", headerCreator.generatedAuthorization(allParams));

            String twitterResponse = Requests.sendPost(url,"oauth_verifier="+oauthVerifier,props);

            //Get user id

            Integer startIndexTmp = twitterResponse.indexOf("user_id")+8;
            Integer endIndexTmp = twitterResponse.indexOf("&",startIndexTmp);
            if(endIndexTmp<=0) endIndexTmp = twitterResponse.length()-1;
            Long userId = Long.parseLong(twitterResponse.substring(startIndexTmp, endIndexTmp));

            //Do what do you want...

        }catch (Exception ex){
            //TODO: Log
            throw new Exception();
        }
    }
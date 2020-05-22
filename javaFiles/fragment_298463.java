Map<String, String> configurationMap = new HashMap<String, String>();
            configurationMap.put("mode", "sandbox");
            APIContext apiContext = new APIContext();
            apiContext.setConfigurationMap(configurationMap);
            tokeninfo = Tokeninfo.createFromAuthorizationCodeForFpp(apiContext, params);
            tokeninfo.setAccessToken(tokeninfo.getTokenType() + " " + tokeninfo.getAccessToken());
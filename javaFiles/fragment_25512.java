HttpTransport netTransport = new NetHttpTransport();
      JsonFactory jsonFactory = new JacksonFactory();
      token = new GoogleAuthorizationCodeTokenRequest(netTransport, 
        jsonFactory, CLIENT_ID, CLIENT_SECRET, authorizationCode, 
        REDIRECT_URI).execute();
      System.out.println("Valid access token " + token.getAccessToken());
       GoogleCredential cd = new GoogleCredential().setAccessToken(token
        .getAccessToken());
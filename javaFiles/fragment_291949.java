ConfigurationBuilder cb = new ConfigurationBuilder();

    cb.setApplicationOnlyAuthEnabled(false);
    cb.setOAuthConsumerKey(CONSUMER_KEY)
    .setOAuthConsumerSecret(CONSUMER_SECRET)
    .setOAuthAccessToken(ACCESS_TOKEN)
    .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
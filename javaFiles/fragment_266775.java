ConfigurationBuilder builder=new ConfigurationBuilder();
            builder.setUseSSL(true);
            builder.setApplicationOnlyAuthEnabled(true);

            // setup
            Twitter twitter = new TwitterFactory(builder.build()).getInstance();

            // exercise & verify
            twitter.setOAuthConsumer(TWITTER_CONSUMER_KEY, TWITTER_CONSUMER_SECRET);
           // OAuth2Token token = twitter.getOAuth2Token();
            twitter.getOAuth2Token();
    statuses = twitter.getUserTimeline("Twitter");
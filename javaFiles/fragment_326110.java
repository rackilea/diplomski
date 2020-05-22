ConfigurationBuilder cb = new ConfigurationBuilder();
cb.setDebugEnabled(true);
cb.setOAuthConsumerKey("*************");
cb.setOAuthConsumerSecret("*************");
cb.setOAuthAccessToken("*************");
cb.setOAuthAccessTokenSecret("*************");

TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
    configurationBuilder.setOAuthConsumerKey(context.getResources().getString(R.string.twitter_consumer_key));
    configurationBuilder.setOAuthConsumerSecret(context.getResources().getString(R.string.twitter_consumer_secret));
    configurationBuilder.setOAuthAccessToken("HERE ENTER UR ACCESS TOKEN RECEIVED IN YOUR WEB SERVICE"));
    configurationBuilder.setOAuthAccessTokenSecret("HERE ENTER UR ACCESS TOKEN SECRET RECEIVED IN YOUR WEB SERVICE"));
    Configuration configuration = configurationBuilder.build();
    final Twitter twitter = new TwitterFactory(configuration).getInstance();

    new Thread(new Runnable() {

            private double x;

            @Override
            public void run() {
                    boolean success = true;
                    try {
                            x = Math.random();
                            twitter.updateStatus(message +" "+x);
                    } catch (TwitterException e) {
                            e.printStackTrace();
                            success = false;
                    }

                    final boolean finalSuccess = success;

                    callingActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                    postResponse.onFinsihed(finalSuccess);
                            }
                    });

            }
    }).start();
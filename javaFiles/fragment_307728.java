ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true).setOAuthConsumerKey("---")
            .setOAuthConsumerSecret("---")
            .setOAuthAccessToken("---")
            .setOAuthAccessTokenSecret("---");

    TwitterStream twitterStream = new TwitterStreamFactory(cb.build())
            .getInstance();
    StatusListener listener = new StatusListener() {

        @Override
        public void onStatus(Status status) {
                //here you do whatever you want with the tweet
            System.out.println(status.getText());

        }

        @Override
        public void onException(Exception ex) {
            ex.printStackTrace();
        }

        @Override
        public void onDeletionNotice(StatusDeletionNotice arg0) {
                  // TODO Auto-generated method stub

        }

        @Override
        public void onScrubGeo(long arg0, long arg1) {

        }

        @Override
        public void onStallWarning(StallWarning arg0) {
            // TODO Auto-generated method stub
            System.out.println(arg0);
        }

        @Override
        public void onTrackLimitationNotice(int arg0) {
            // TODO Auto-generated method stub
            System.out.println(arg0);
        }

    };

    twitterStream.addListener(listener);
    FilterQuery filterQuery = new FilterQuery();
    double[][] locations = {{-74,40}, {-73,41}}; //those are the boundary from New York City
    filterQuery.locations(locations);
    twitterStream.filter(filterQuery);
    twitterStream.filter(filterQuery);
StatusListener statusListner=new StatusListener() {

            @Override
            public void onStatus(Status status) {
                System.out.println("Status Recvd: "+status.getText());
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice sdn) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onTrackLimitationNotice(int i) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onScrubGeo(long l, long l1) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onStallWarning(StallWarning sw) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onException(Exception excptn) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        TwitterStream twitterStream2 = new TwitterStreamFactory(new ConfigurationBuilder().setJSONStoreEnabled(true).build()).getInstance();

        twitterStream2.setOAuthConsumer(StaticConstants.API_KEY, StaticConstants.API_SECRET);
        AccessToken token2 = new AccessToken(StaticConstants.TOKEN_KEY, StaticConstants.TOKEN_SECRET);
        twitterStream2.setOAuthAccessToken(token2);

        twitterStream2.addListener(statusListner);
        FilterQuery query = new FilterQuery();
        query.follow(new long[]{12384567l});
        twitterStream2.filter(query);
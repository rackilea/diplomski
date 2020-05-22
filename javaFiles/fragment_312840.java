TwitterStream twitterStream = new TwitterStreamFactory(config).getInstance();

        StatusListener statusListener = new StatusListener() {
            private int count = 0;
            private long originalTweetId = 0;

            @Override
            public void onStatus(Status status) {

            // status object here is the tweet object that caught by the stream. You    can do whatever you want with it.

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
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void onException(Exception ex) {
                logWriter.WriteErrorLog(ex, "onException()");
            }
        };

        FilterQuery fq = new FilterQuery();

        String keywords[] = {keyword};

        fq.track(keywords);

        twitterStream.addListener(statusListener);
        twitterStream.filter(fq);
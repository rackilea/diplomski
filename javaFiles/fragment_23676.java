final LinearLayout tweet_layout
            = (LinearLayout) findViewById(R.id.tweet_layout);

    final List<Long> tweetIds = Arrays.asList(your_tweet_id);
    TweetUtils.loadTweets(tweetIds, new Callback<Tweet>() {
        @Override
        public void success(Result<Tweet> result) {
            for (Tweet tweet : result.data) {
                tweet_layout.addView(new TweetView(TweetActivity.this, tweet));
            }
        }

        @Override
        public void failure(TwitterException exception) {
            // Do something here.
        }
    });
}
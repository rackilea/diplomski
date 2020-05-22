private ArrayList<Tweet> tweetList = new ArrayList<>();

public void tweetList() { 
   final ArrayList<Tweet> tweets = new ArrayList<>();
   final UserTimeline userTimeline = new UserTimeline.Builder()
           .screenName("xxxxxxxx")
           .build();
   userTimeline.next(null, new Callback<TimelineResult<Tweet>>() {
       @Override
       public void success(Result<TimelineResult<Tweet>> result) {
           for(Tweet tweet : result.data.items){
               tweets.add(tweet);
           }

           this.tweetList = tweets;

           // execute the next sequence of instructions in your program here
           // and make use of tweetList instead of tweets

       }

       @Override
       public void failure(TwitterException exception) {
           exception.printStackTrace();
       }
   });
}
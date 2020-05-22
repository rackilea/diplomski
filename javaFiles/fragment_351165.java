public class MyTwitterApp implements {

private Twitter twitter;
private Query query;

public MyTwitterApp (){
    twitter = TwitterFactory.getSingleton();
}

public static void main(String[] args) {
    MyTwitterApp twitterApp  = new MyTwitterApp();
    twitterApp.getStreamingTweets();

}

public void getStreamingTweets(){
    StatusListener listener = new StatusListener(){
        public void onStatus(Status status) {
                handleStatus(status);
        }
        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
        public void onException(Exception ex) {ex.printStackTrace(); }
        public void onScrubGeo(long arg0, long arg1) {}
        public void onStallWarning(StallWarning arg0) {}
    };
    twitter.addListener(listener);
    FilterQuery fq = new FilterQuery();
    fq.count(0);
    fq.track(new String[]{"#MyHashTag"});
    twitter.filter(fq);
}

protected void handleStatus(Status tweet) {
    if(tweet.isRetweet()){
        return;
    }
    if(isMyHashTagTweet(tweet)){
        //do something with tweet here      
    }       
}

private boolean isMyHashTagTweet(Status tweet) {
    HashtagEntity[] htes = tweet.getHashtagEntities();
    for(HashtagEntity hte : htes){
        if(hte.getText().equalsIgnoreCase("myhashtag")) {
            return true;
        }
    }
    return false;
}
}
ConfigurationBuilder cb = new ConfigurationBuilder();
cb.setDebugEnabled(true)
  .setOAuthConsumerKey(" ")
  .setOAuthConsumerSecret(" ")
  .setOAuthAccessToken(" ")
  .setOAuthAccessTokenSecret(" ");
Twitter twitter = new TwitterFactory(cb.build()).getInstance();
Query query = new Query("hashtag");
int numberOfTweets = 7;
long lastID = Long.MAX_VALUE;
ArrayList<Status> tweets = new ArrayList<Status>();

while (tweets.size () < numberOfTweets) {
  if (numberOfTweets - tweets.size() > 100)
    query.setCount(100);
  else 
    query.setCount(numberOfTweets - tweets.size());
  try {
    QueryResult result = twitter.search(query);
    tweets.addAll(result.getTweets());
    System.out.println("Gathered " + tweets.size() + " tweets"+"\n");
    for (Status t: tweets) 
      if(t.getId() < lastID) 
          lastID = t.getId();

  }

  catch (TwitterException te) {
    System.out.println("Couldn't connect: " + te);
  }; 
  query.setMaxId(lastID-1);
}
for (int i = 0; i < tweets.size(); i++) {
  Status t = (Status) tweets.get(i);

 // GeoLocation loc = t.getGeoLocation();

  String user = t.getUser().getScreenName();
  String msg = t.getText();
  //String time = "";
  //if (loc!=null) {
    //Double lat = t.getGeoLocation().getLatitude();
    //Double lon = t.getGeoLocation().getLongitude();*/
   System.out. println(i + " USER: " + user + " wrote: " + msg + "\n");
  } 
  //else 
    //System.out.println(i + " USER: " + user + " wrote: " + msg+"\n");
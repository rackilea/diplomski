@Override
protected void onCreate(Bundle savedInstanceState) {

 //END OF PART Z
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//PART Z
    String consumerKey = "YII";
    String consumerSecret = "YII";
    String accessToken = "YII";
    String accessTokenSecret = "YII";   

    //Instantiate a re-usable and thread-safe factory
    TwitterFactory twitterFactory = new TwitterFactory();

    //Instantiate a new Twitter instance
    Twitter twitter = twitterFactory.getInstance();

    //setup OAuth Consumer Credentials
    twitter.setOAuthConsumer(consumerKey, consumerSecret);

    //setup OAuth Access Token
    twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));

     try {
         User user = twitter.verifyCredentials();
         List<Status> statuses = twitter.getMentionsTimeline();
         System.out.println("Showing @" + user.getScreenName() + "'s mentions.");
         for (Status status : statuses) {
             System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
         }
     } catch (TwitterException te) {
         te.printStackTrace();
         System.out.println("Failed to get timeline: " + te.getMessage());
     }
    int a = 6;
    int b = 2; 
    System.out.println(a+b);

}
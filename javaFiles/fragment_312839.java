public static ConfigurationBuilder confBuilder = null;
public static Configuration config = null;
public static Twitter twitterObj = null;

confBuilder = new twitter4j.conf.ConfigurationBuilder();
confBuilder.setDebugEnabled(true);

confBuilder.setOAuthConsumerKey("consumerKey");
confBuilder.setOAuthConsumerSecret("consumerSecret");
confBuilder.setOAuthAccessToken("accessToken");
confBuilder.setOAuthAccessTokenSecret("accessTokenSecret");

config = confBuilder.build();

twitter4j.TwitterFactory tf = new twitter4j.TwitterFactory(config);
twitterObj = tf.getInstance(); //Here, finally we got the twitter object.
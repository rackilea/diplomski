public class MyConfigurationBuilder {
    private ConfigurationBuilder cb; 
    private Twitter twitter;

    public MyConfigurationBuilder() {
      cb = new ConfigurationBuilder();
      cb.setDebugEnabled(true)
        .setOAuthConsumerKey("***")
        .setOAuthConsumerSecret("***")
        .setOAuthAccessToken("***")
        .setOAuthAccessTokenSecret("***");
      TwitterFactory tf = new TwitterFactory(cb.build());
      twitter = tf.getInstance();
    }
}
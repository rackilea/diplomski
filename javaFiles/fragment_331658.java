StatusListener statusListener = new StatusListener() {
    @Override
    public void onStatus(Status status) {
        //your code to manage the statuses
    }
    //other requiredly-overriden methods
}
ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
configurationBuilder.setOAuthConsumerKey("XXXXX");
configurationBuilder.setOAuthConsumerSecret("XXXXXXX");
TwitterStream twitterStream = new TwitterStreamFactory(configurationBuilder.build()).getInstance(new AccessToken("XXXXX", "XXXXXXX"));
twitterStream.addListener(statusListener);

//from here is different at your code

//you need to set up your user list, with their users id's!
long[] userslist = YOUR USER LIST;
//then you create a filter
FilterQuery filtre = new FilterQuery();
//and use that filter to follow the users that you want and to start the stream
filtre.follow(userslist);
twitterStream.filter(filtre);
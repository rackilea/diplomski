void setup() {
  size(600, 600); 
  smooth();
  noStroke();
  ConfigurationBuilder cb = new ConfigurationBuilder();
  cb.setOAuthConsumerKey("xxxxx");
  cb.setOAuthConsumerSecret("xxxxxx");
  cb.setOAuthAccessToken("xxxxxxx");
  cb.setOAuthAccessTokenSecret("xxxxx"); 


  TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

  String keywords[] = {
    "happy", "sad", "okay"
  };

  FilterQuery fq = new FilterQuery();
  fq.track(keywords);
  twitterStream.addListener(statusListener);
  twitterStream.filter(fq);
}

void draw() {
}

void method1()
{
  System.out.println("method1 can be called and it works!!");
}
void method2()
{
  System.out.println("method2 can be called and it works!!");
}

void method3()
{
  System.out.println("method3 can be called and it works!!");
}

StatusListener statusListener = new StatusListener() {
   @Override
  public void onStatus(Status status) {
    // Here do whatever you want with the status object that is the       
    //  tweet you got
    System.out.println(status.getUser().getName() + " : " + status.getText());
    if (status.getText().contains("happy")) {
      method1();
      System.out.println("A happy tweet");
    }
    if (status.getText().contains("okay")) {
      method2();
      System.out.println("A okay tweet");
    }
    if (status.getText().contains("sad")) {
      method3();
      System.out.println("A sad tweet ");
    }
  } //en of the onStatus()
  public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
    // should really remove deleted tweets here ...
  }

  public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
  }

  public void onScrubGeo(long userId, long upToStatusId) {
    // should really remove deleted location information here ...
  }

  public void onStallWarning(StallWarning stallWarning) {
    // should really do something about stalls here ...
    System.out.println(stallWarning);
  }
   @Override
  public void onException(Exception ex) {
    ex.printStackTrace();
  }
}; //end of the listener
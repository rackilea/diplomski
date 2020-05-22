public class Stream {

  public static void main(String[] args) throws TwitterException {
    Stream stream = new Stream();
    stream.execute();
  }

  private final Object lock = new Object();
  public List<Status> execute() throws TwitterException {

    final List<Status> statuses = new ArrayList();

    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true);
    cb.setOAuthConsumerKey("bbb");
    cb.setOAuthConsumerSecret("bbb");
    cb.setOAuthAccessToken("bbb");
    cb.setOAuthAccessTokenSecret("bbb");

    TwitterStream twitterStream = new TwitterStreamFactory(cb.build())
        .getInstance();

    StatusListener listener = new StatusListener() {

      public void onStatus(Status status) {
        statuses.add(status);
        System.out.println(statuses.size() + ":" + status.getText());
        if (statuses.size() > 100) {
          synchronized (lock) {
            lock.notify();
          }
          System.out.println("unlocked");
        }
      }

      public void onDeletionNotice(
          StatusDeletionNotice statusDeletionNotice) {
        System.out.println("Got a status deletion notice id:"
            + statusDeletionNotice.getStatusId());
      }

      public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
        System.out.println("Got track limitation notice:"
            + numberOfLimitedStatuses);
      }

      public void onScrubGeo(long userId, long upToStatusId) {
        System.out.println("Got scrub_geo event userId:" + userId
            + " upToStatusId:" + upToStatusId);
      }

      public void onException(Exception ex) {
        ex.printStackTrace();
      }

      @Override
      public void onStallWarning(StallWarning sw) {
        System.out.println(sw.getMessage());

      }
    };

    FilterQuery fq = new FilterQuery();
    String keywords[] = { "federer", "nadal", "#Salute" };

    fq.track(keywords);


    twitterStream.addListener(listener);
    twitterStream.filter(fq);

    try {
      synchronized (lock) {
        lock.wait();
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("returning statuses");
    twitterStream.shutdown();
    return statuses;
  }
}
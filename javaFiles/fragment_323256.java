public class Client {

  private Broadcaster broadcaster;

  public void join(Broadcaster broadcaster) {
    this.broadcaster = broadcaster;
    broadcaster.announce(this);
  }

}
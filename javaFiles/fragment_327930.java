public class Reg {
    private boolean registered;

    synchronized boolean registered() {
      return registered;
    }

    void setRegistered(boolean registered) {
      synchronized (this) {
        this.registered = registered;
      }
    }
}
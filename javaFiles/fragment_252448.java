public abstract class DongleManager implements IDongle {

  private boolean connected = false;
  public void setConnected(boolean status) {
      connected = status;
  }
  public boolean getConnected() {
      return connected;
  }
}
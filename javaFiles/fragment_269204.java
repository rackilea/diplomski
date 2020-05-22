public class KeyGameEvent extends GameEvent {

  public int keyCode;
  public KeyEvent keyEvt;
  public boolean up;

  public KeyGameEvent(int keyCode, boolean keyUp, KeyEvent evt) {
    this.keyCode = keyCode;
    this.up = keyUp;
    this.keyEvt = evt;
  }

}
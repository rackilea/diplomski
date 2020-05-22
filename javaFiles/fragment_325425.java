public class LockableInt {

  private int value;
  private boolean locked = false;

  public LockableInt(int initial) {
     value = initial;
  }

  public void setLock(boolean locked) { this.locked = locked; }

  /* Sets the value if not locked, otherwise does nothing.
   */
  public void setValue(int value) {
    if (!locked) { 
      this.value = value; 
    }
  }

  public int getValue() {
    return value;
  }
}
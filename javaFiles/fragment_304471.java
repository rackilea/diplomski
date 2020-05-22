class Player {

  // Same instance shared for all players... Don't show how we get it now.
  // Use one dimensional board to simplify, doesn't matter here.
  private List<Player>[] fields; 

  // Current position
  private int x;

  private static Object sharedLock = new Object(); // Any object's instance can be used as a lock.

  public int getX() {
    synchronized(sharedLock) {
      return x;
    }
  }

  public void setX(int x) {
    synchronized(sharedLock) {
      // Because of using a single shared lock,
      // several players can't access fields at the same time
      // and so can't create inconsistencies on fields.
      fields[x].remove(this); 
      this.x = x;
      field[y].add(this);
    }
  }
}
class Player {

  // Same instance shared for all players... Don't show how we get it now.
  // Use one dimensional board to simplify, doesn't matter here.
  private List<Player>[] fields = Board.getBoard(); 

  // Current position
  private int x; 

  public synchronized int getX() {
    return x;
  }

  public void setX(int x) {
    synchronized(this) { // Same as synchronized method
      fields[x].remove(this);
      this.x = x;
      field[y].add(this);
    }
  }
}
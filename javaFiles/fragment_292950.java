public class PlayerTester {

  public static void main(String[] args) {
    PlayerTester pt = new PlayerTester();
    pt.insertThird(new Player());
  }

  public void insertThird(Player p) {
    PlayerNode pn = new PlayerNode(p);
    PlayerNode current = head;

    if (current == null) {
      head = pn;
    }
    else {
      current = current.getNext();
      if (current != null) {
        pn.setNext(current.getNext());
        current.setNext(pn);
      }
      else {
        head.setNext(pn);
      }
    }
    numberOfItems++;
  }
}
public class Test {
   // Same as above . . .
}

class Subclass extends Test {

  private int subclassItem = 1;

  public int getItem() {
    return subclassItem;
  }

  public void setItem(int item) {
    this.subclassItem = item;
  }

}
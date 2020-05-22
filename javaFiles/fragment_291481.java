public abstract class MenuItem{

  public MenuItem(String itemName, int ct, double costPer) {
    this.itemName = itemName;
    this.ct = ct;
    this.costPer = costPer;
  }
  ...
}

public class Hamburger extends MenuItem{

  public Hamburger() {
    super("Hamburger", 0, 4.99)
  }

}
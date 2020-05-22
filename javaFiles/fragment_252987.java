public class Color implements Cloneable {
  protected String name = "Red";

  public String ColorName() {
    return name;
  }

  @Override
  public Object clone() {
    Color c = new Color();
    c.name = this.name;
    return c;
  }
}
public class NameAge {
  public final String name;
  public final int age;
  public NameAge(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
// ...
public NameAge getItem() { return new NameAge("Jen", 23); }
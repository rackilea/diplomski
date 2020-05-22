public abstract class BaseClass {
  static boolean optionalIsPresent(Optional<?> possible) {
    return (possible == null) ? false : possible.isPresent();
    // return possible.isPresent();
  }

  public final String name;

  public Optional<Integer> getID();

  protected BaseClass() {
    if (optionalIsPresent(getID())) {
      name = "number " + getID().get();
    } else {
      name = "nameless";
    }
  }
}

public class DerivedClass extends BaseClass {
  private final int id;

  public DerivedClass(int id) {
    this.id = id;
  }

  public Optional<Integer> getID() {
    return Optional.of(id);
  }
}
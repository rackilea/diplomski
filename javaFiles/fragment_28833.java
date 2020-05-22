public class Car {
  private final Engine engine;

  // ... 

  @Override
  public Car clone() {
    try {
      Type copy = (Type) super.clone();
      copy.engine = (Engine) engine.clone(); // Error: final field cannot be modified.
      return copy;
    } catch (CloneNotSupportedException cnse) {
      throw new RuntimeException(cnse);
    }
  }
}
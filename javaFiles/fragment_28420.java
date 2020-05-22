@XmlRootElement(name = "null")
@XmlType(factoryClass = Null.Factory.class, factoryMethod = "nullInstance")
public final class Null extends Value {
  public static class Factory {
    public static Null nullInstance(
    ) {
      return INSTANCE;
    }
  }

  public static final Null INSTANCE = new Null();

  // Construct

  /**
   * Construct
   */
  private Null(
  ) {
    if (INSTANCE != null) {
      throw new RuntimeException("Null is a singleton class");
    }
  }

  // Object

  @Override
  public String toString(
  ) {
    return getClass().getSimpleName();
  }

  // Value

  @Override
  public boolean isCompound(
  ) {
    return false;
  }

  @Override
  public boolean isScalar(
  ) {
    return true;
  }
}
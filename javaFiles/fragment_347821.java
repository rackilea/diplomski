abstract class Fruit {
  @Override
  public final String toString() {
    return getClass().getSimpleName() + getSize();
  }

  abstract String getSize();
public class Super {
  private final int superValue;

  protected Super() {
    superValue = getSuperValue();
  }

  protected int getSuperValue() {
    return 1;
  }

  @Override
  public String toString() {
    return Integer.toString(superValue);
  }
}

public class Sub extends Super {
  private final int superValueOverride;

  public Sub(int value) {
    this.superValueOverride = value;
  }

  @Override
  protected int getSuperValue() {
    return superValueOverride;
  }

  public static void main(String[] args) {
    Super s = new Sub(2);
    System.out.println(s);
  }
}
public abstract class Test {
  private final ArrayList<Object> objects;

  protected ArrayList<Object> getObjects() {
    return objects;
  }

  protected Test(ArrayList<Object> objects) {
    this.objects = objects;
  }
}

public class TestSubA extends Test {

  public TestSubA() {
    super(new ArrayList<Object>(20));
    // Other stuff
  }
}

public class TestSubB extends Test {

  public TestSubB() {
    super(new ArrayList<Object>(100));
    // Other stuff
  }
}
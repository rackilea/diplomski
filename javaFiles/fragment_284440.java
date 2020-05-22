public interface Service {
  void useService();
}

public class FooService implements Service {
  public void useService() {
    System.out.println("foo service used");
  }
}

public class BarService implements Service {
  public void useService() {
    System.out.println("bar service used");
  }
}
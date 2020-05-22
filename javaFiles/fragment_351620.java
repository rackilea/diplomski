public interface MyObject<T> {
  T getId();
  String getName();
}

public class ObjectA implements MyObject<Integer> {
  @Override
  public Integer getId() {
    return 0;
  }

  @Override
  public String getName() {
    return "A";
  }
}

public class ObjectB implements MyObject<Long> {
  @Override
  public Long getId() {
    return 0;
  }

  @Override
  public String getName() {
    return "B";
  }
}
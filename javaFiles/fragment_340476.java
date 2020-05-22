interface FieldGetter {
  Object getValue();
}

interface FieldSetter {
  void setValue(Object value);
}

public class SetterInterceptor {
  @RuntimeType
  public  Object intercept(@FieldProxy("stringVal") FieldGetter accessor) {
    Object value = accessor.getValue();
    System.out.println("Invoked method with: " + value);
    return value;
  }
}
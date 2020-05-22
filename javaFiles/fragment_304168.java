public class MyParamType implements ParameterizedType {
  private Type rawType;
  private List<Type> paramTypes;

  public MyParamType( Type raw ) {
    this.rawType = raw;
  }

  public void addParamType( Type t ) {
    paramTypes.add(t);
  }

  //for the interface methods, just return what you stored before
}
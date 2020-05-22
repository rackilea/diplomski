public class SuperClass {
  // Constructor
  @Inject SuperClass(Provider<? extends SuperClass.Parameters> superParam) {
  }

  public class Parameters {
    int a;  
  }
}

public class Sub extends SuperClass {
  @Inject Sub(Provider<Sub.Parameters> subParam) {
     super(subParam);
  }

  public class Parameters extends SuperClass.Parameters {
    int b;
  }
}
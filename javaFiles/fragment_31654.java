public class MyFactoryImpl implements MyFactory{

   private final SomeService someService;

   @Inject
   public MyFactoryImpl(SomeService someService){
      this.someService = someService;
   }

   public MyClass createMyClass(String dynamicParameter){
      return new MyClass(dynamicParameter, someService);
   }

   ...
}
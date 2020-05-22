@Test
public void test() {
  SomeOtherClassObject other = ...; // what ever you need to create the Mock
  Injector injector = Guice.createInjector(new AbstractModule(){
    public void configure() {
      bind(SomeOtherClassObject.class)toInstance(other);
    }
   });
   SomeClass some = injector.getInstance(SomeClass.class); // guice takes care of the constructor injection
   some.someMethod(...);
  }
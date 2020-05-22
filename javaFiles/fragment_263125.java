@Configuration
public class MyApplicationContext {

  @Bean(name = "someBean")
  public SomeClass getSomeClass() {
    return new SomeClassImpl(someInterestingProperty); // We still need to inject someInterestingProperty
  }

  @Bean(name = "anotherBean")
  public AnotherClass getAnotherClass() {
    return new AnotherClassImpl(getSomeClass(), beanFromSomewhereElse); // We still need to inject beanFromSomewhereElse
  }
}
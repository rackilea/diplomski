import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class DynamicBinding {
  static final String interfaceExample = "DynamicBinding$Foo";
  static final String implementationExample = "DynamicBinding$FooBar";

  public static void main(String... args) throws ClassNotFoundException {
    Injector inj = Guice.createInjector(new CustomModule());
    Foo blue = inj.getInstance(Foo.class);
    blue.doSomething();
  }

  static class CustomModule extends AbstractModule {

    @Override
    protected void configure() {
      // for (Entry<interface, implementation> : xml file) {
      bindFromStrings(interfaceExample, implementationExample);
      // }
    }

    private void bindFromStrings(String interfaceClass, String implClass) {
      try {
        Class fooClass = Class.forName(interfaceClass);
        // I recommend defining a custom exception here with a better message
        if (!fooClass.isInterface()) {
          throw new Exception("fooClass must be an interface!");
        }

        Class fooBarClass = Class.forName(implClass);
        // I recommend defining a custom exception here with a better message
        if (!fooClass.isAssignableFrom(fooBarClass)) {
          throw new Exception("classes must be in same inheritance hierarchy");
        }

        bind(fooClass).to(fooBarClass);
      } catch (Exception e) {
        // Logger.getLogger().log(blah);
        e.printStackTrace();
      }
    }
  }

  public static interface Foo {
    void doSomething();
  }

  public static class FooBar implements Foo {
    @Override
    public void doSomething() {
      System.out.println(this.getClass());
    }
  }
}
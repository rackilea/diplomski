public interface IFoo {
 String getName();
}

public abstract class Foo implements IFoo {

 protected String name;

 String getName() {
  return name;
 }
}
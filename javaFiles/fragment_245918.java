public interface Foo<T extends Foo<T>> {
    T getBlah();
}

public class Bar implements Foo<Bar> {
   @Override
   public Bar getBlah() {  
      return this;
   }
}
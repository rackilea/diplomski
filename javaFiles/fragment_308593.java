public class Bar<T> {

   private Foo<T> foo;

   Bar(T x) {
      foo = new Foo<T>(x);
   }
}
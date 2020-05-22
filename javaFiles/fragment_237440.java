public class ComparableFoo implements Comparable<ComparableFoo> {

   final Foo foo;

   public ComparableFoo(Foo foo) {
      this.foo = foo;
   }

   @Override
   public int compareTo(ComparableFoo o) {
      Foo other = o.foo;
      // do comparison here, e.g.
      return foo.getDate().compareTo(other.getDate());
   }

}
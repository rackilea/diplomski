public class Awesome implements Footastic,scala.ScalaObject {
  public void foo(scala.collection.Seq<Foo>);
    Code:
       0: getstatic     #11                 // Field scala/Predef$.MODULE$:Lscala/Predef$;
       3: ldc           #14                 // String WIN
       5: invokevirtual #18                 // Method scala/Predef$.println:(Ljava/lang/Object;)V
       8: return

  public void foo(Foo[]);
    Code:
       0: aload_0
       1: getstatic     #11                 // Field scala/Predef$.MODULE$:Lscala/Predef$;
       4: aload_1
       5: checkcast     #28                 // class "[Ljava/lang/Object;"
       8: invokevirtual #32                 // Method scala/Predef$.wrapRefArray:([Ljava/lang/Object;)Lscala/collection/mutable/WrappedArray;
      11: invokevirtual #36                 // Method foo:(Lscala/collection/Seq;)V
      14: return

  public Awesome();
    Code:
       0: aload_0
       1: invokespecial #43                 // Method java/lang/Object."<init>":()V
       4: return
}
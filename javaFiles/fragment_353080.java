Compiled from "Foo.scala"
public class com.testing.Foo {
  public scala.Tuple2<java.lang.Object, java.lang.Object> intsNullTuple();
    Code:
       0: new           #12                 // class scala/Tuple2$mcII$sp
       3: dup
       4: aconst_null
       5: invokestatic  #18                 // Method scala/runtime/BoxesRunTime.unboxToInt:(Ljava/lang/Object;)I
       8: iconst_2
       9: invokespecial #22                 // Method scala/Tuple2$mcII$sp."<init>":(II)V
      12: areturn

  public scala.Tuple2<java.lang.Object, java.lang.String> intAndStringNullTuple();
    Code:
       0: new           #27                 // class scala/Tuple2
       3: dup
       4: aconst_null
       5: ldc           #29                 // String 2
       7: invokespecial #32                 // Method scala/Tuple2."<init>":(Ljava/lang/Object;Ljava/lang/Object;)V
      10: areturn

  public com.testing.Foo();
    Code:
       0: aload_0
       1: invokespecial #35                 // Method java/lang/Object."<init>":()V
       4: return
}
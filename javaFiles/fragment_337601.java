javap -c Son.class

public class Son implements Father$mcI$sp {

  public int get$mcI$sp(int);
    Code:
       0: getstatic     #25                 // Field scala/Predef$.MODULE$:Lscala/Predef$;
       3: ldc           #27                 // String Son.get
       5: invokevirtual #31                 // Method scala/Predef$.println:(Ljava/lang/Object;)V
       8: aload_0
       9: iload_1
      10: invokestatic  #37                 // Method scala/runtime/BoxesRunTime.boxToInteger:(I)Ljava/lang/Integer;
      13: invokestatic  #43                 // InterfaceMethod Father.get$:(LFather;Ljava/lang/Object;)Ljava/lang/Object;
      16: invokestatic  #47                 // Method scala/runtime/BoxesRunTime.unboxToInt:(Ljava/lang/Object;)I
      19: ireturn
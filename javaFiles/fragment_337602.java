javap -c Father.class 

public interface Father<A> {
  public static java.lang.Object get$(Father, java.lang.Object);
    Code:
       0: aload_0
       1: aload_1
       2: invokespecial #17                 // InterfaceMethod get:(Ljava/lang/Object;)Ljava/lang/Object;
       5: areturn

  public A get(A);
    Code:
       0: aload_1
       1: areturn

  public static int get$mcI$sp$(Father, int);
    Code:
       0: aload_0
       1: iload_1
       2: invokespecial #26                 // InterfaceMethod get$mcI$sp:(I)I
       5: ireturn

  public int get$mcI$sp(int);
    Code:
       0: aload_0
       1: iload_1
       2: invokestatic  #33                 // Method scala/runtime/BoxesRunTime.boxToInteger:(I)Ljava/lang/Integer;
       5: invokeinterface #17,  2           // InterfaceMethod get:(Ljava/lang/Object;)Ljava/lang/Object;
      10: invokestatic  #37                 // Method scala/runtime/BoxesRunTime.unboxToInt:(Ljava/lang/Object;)I
      13: ireturn
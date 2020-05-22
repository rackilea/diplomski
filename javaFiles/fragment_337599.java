javap -c Son.class

public class Son extends Father$mcI$sp {
  public int get(int);
    Code:
       0: aload_0
       1: iload_1
       2: invokevirtual #14                 // Method get$mcI$sp:(I)I
       5: ireturn

  public int get$mcI$sp(int);
    Code:
       0: getstatic     #23                 // Field scala/Predef$.MODULE$:Lscala/Predef$;
       3: ldc           #25                 // String Son.get
       5: invokevirtual #29                 // Method scala/Predef$.println:(Ljava/lang/Object;)V
       8: aload_0
       9: iload_1
      10: invokespecial #31                 // Method Father$mcI$sp.get:(I)I
      13: ireturn
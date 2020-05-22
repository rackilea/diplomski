$ javap -c Foo.class 
Compiled from "Foo.java"
public class Foo {
  public Foo();
    Code:
       0: aload_0
       1: invokespecial #8                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #16                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #22                 // String Test
       5: invokevirtual #24                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: new           #1                  // class Foo
      11: invokespecial #30                 // Method "<init>":()V
      14: return
}
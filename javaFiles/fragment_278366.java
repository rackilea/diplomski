Compiled from "Test.java"
public class Test {
  public static volatile java.lang.String A;

  public Test();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]) throws java.lang.Exception;
    Code:
       0: new           #2                  // class java/lang/StringBuilder
       3: dup
       4: invokespecial #3                  // Method java/lang/StringBuilder."<init>":()V
       7: getstatic     #4                  // Field A:Ljava/lang/String;
      10: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      13: ldc           #6                  // String B
      15: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      18: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      21: astore_1
      22: new           #2                  // class java/lang/StringBuilder
      25: dup
      26: invokespecial #3                  // Method java/lang/StringBuilder."<init>":()V
      29: getstatic     #4                  // Field A:Ljava/lang/String;
      32: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      35: bipush        66
      37: invokevirtual #8                  // Method java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
      40: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      43: astore_2
      44: aload_1
      45: aload_2
      46: invokevirtual #9                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      49: pop
      50: return

  static {};
    Code:
       0: ldc           #10                 // String A String
       2: putstatic     #4                  // Field A:Ljava/lang/String;
       5: return
}
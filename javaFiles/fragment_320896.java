Compiled from "TestClass.jasm"
public class TestClass
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC
{
  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #16                 // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #18                 // String hello world
         5: invokevirtual #24                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0   arg   [Ljava/lang/String;
      LineNumberTable:
        line 17: 0
        line 18: 3
        line 19: 5
        line 20: 8
}
SourceFile: "TestClass.jasm"
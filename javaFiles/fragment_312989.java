public class Test extends java.lang.Object
  SourceFile: "Test.java"
  minor version: 0
  major version: 50
  Constant pool:
  --snip--

{
int class_member;

public Test();
  Code:
   Stack=2, Locals=2, Args_size=1
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   aload_0
   5:   bipush  42
   7:   putfield        #2; //Field class_member:I
   10:  bipush  42
   12:  istore_1
   13:  return
  LineNumberTable:
   --snip--    
}
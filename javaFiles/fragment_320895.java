// class version 52.0 (52)
// access flags 0x1
public class TestClass {


  // access flags 0x2
  private <init>()V
    ALOAD 0
    INVOKESPECIAL java/lang/Object.<init> ()V
    RETURN
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x9
  public static main([Ljava/lang/String;)V
   L0
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    LDC "hello world"
    INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/String;)V
    RETURN
   L1
    LOCALVARIABLE arg [Ljava/lang/String; L0 L1 0
    MAXSTACK = 2
    MAXLOCALS = 1
}
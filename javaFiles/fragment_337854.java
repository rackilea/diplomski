// class version 52.0 (52)
// access flags 0x21
public class com/xetrasu/CounterPoint extends java/awt/Point  {

  // compiled from: CounterPoint.java

  // access flags 0x1A
  private final static Ljava/util/concurrent/atomic/AtomicInteger; counter

  // access flags 0x1
  public <init>(II)V
   L0
    LINENUMBER 11 L0
    ALOAD 0
    ILOAD 1
    ILOAD 2
    INVOKESPECIAL java/awt/Point.<init> (II)V
   L1
    LINENUMBER 12 L1
    GETSTATIC com/xetrasu/CounterPoint.counter : Ljava/util/concurrent/atomic/AtomicInteger;
    INVOKEVIRTUAL java/util/concurrent/atomic/AtomicInteger.incrementAndGet ()I
    POP
   L2
    LINENUMBER 13 L2
    RETURN
   L3
    LOCALVARIABLE this Lcom/xetrasu/CounterPoint; L0 L3 0
    LOCALVARIABLE x I L0 L3 1
    LOCALVARIABLE y I L0 L3 2
    MAXSTACK = 3
    MAXLOCALS = 3

  // access flags 0x9
  public static numberCreated()Ljava/lang/String;
   L0
    LINENUMBER 16 L0
    GETSTATIC com/xetrasu/CounterPoint.counter : Ljava/util/concurrent/atomic/AtomicInteger;
    INVOKEVIRTUAL java/util/concurrent/atomic/AtomicInteger.toString ()Ljava/lang/String;
    ARETURN
    MAXSTACK = 1
    MAXLOCALS = 0

  // access flags 0x8
  static <clinit>()V
   L0
    LINENUMBER 8 L0
    NEW java/util/concurrent/atomic/AtomicInteger
    DUP
    INVOKESPECIAL java/util/concurrent/atomic/AtomicInteger.<init> ()V
    PUTSTATIC com/xetrasu/CounterPoint.counter : Ljava/util/concurrent/atomic/AtomicInteger;
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 0
}
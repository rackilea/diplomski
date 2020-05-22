.class public HelloWorld
.super java/lang/Object

.method public <init>()V
  .limit stack 2
  aload_0
  invokenonvirtual java/lang/Object/<init>()V
  ldc              "Hello World."
  astore_0
  getstatic        java/lang/System/out Ljava/io/PrintStream;
  aload_0
  invokevirtual    java/io/PrintStream/println(Ljava/lang/String;)V
  return
.end method

.method public static main([Ljava/lang/String;)V
  .limit stack 2
  new HelloWorld
  invokenonvirtual HelloWorld/<init>()V
  return
.end method
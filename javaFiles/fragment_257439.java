.version 51 0
.class super public A
.super java/lang/Object


.method public <init> : ()V
    .limit stack 1
    .limit locals 1
    aload_0
    invokespecial java/lang/Object <init> ()V
    return
.end method

.method static public main : ([Ljava/lang/String;)V
    .limit stack 2
    .limit locals 1
    getstatic java/lang/System out Ljava/io/PrintStream;
    ldc 'true'
    invokevirtual java/io/PrintStream println (Ljava/lang/String;)V
    return
.end method
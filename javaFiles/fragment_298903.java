.version 51 0
.class super public StackFrameTest4
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
    new StackFrameTest
    dup
    invokespecial StackFrameTest <init> ()V
    bipush 42
    invokevirtual StackFrameTest stackFrameTest (I)I
    pop
    return
.end method

.method public stackFrameTest : (I)I
    .limit stack 2
    .limit locals 2
    iload_1
    ifle L12
    getstatic java/lang/System out Ljava/io/PrintStream;
    ldc 'positive x'
    invokevirtual java/io/PrintStream println (Ljava/lang/String;)V
L12:
.stack full
    locals Double Float
    stack Double
.end stack

    iload_1
    ineg
    ireturn
.end method
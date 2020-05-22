.class public ctors
.super java/lang/Object

; A normal constructor
.method public <init> : ()V
    .limit locals 1
    .limit stack 1

    aload_0
    invokespecial java/lang/Object <init> ()V
    return
.end method

; A weird constructor
.method public <init> : (I)V
    .limit locals 2
    .limit stack 5

    iload_1
    ifne LREST
        aload_0
        invokespecial ctors <init> ()V
        return

LREST:
    aload_0
    new ctors
    iinc 1 -1
    iload_1
LFAKE_START:
    invokespecial ctors <init> (I)V
LFAKE_END:
    iconst_0
    invokespecial ctors <init> (I)V
    return

.catch [0] from LFAKE_START to LFAKE_END using LCATCH
LCATCH:
    aload_0
    invokespecial java/lang/Object <init> ()V
    return
.end method

.method public static main : ([Ljava/lang/String;)V
    .limit locals 1
    .limit stack 2

    new ctors
    iconst_5
    invokespecial ctors <init> (I)V
    return
.end method
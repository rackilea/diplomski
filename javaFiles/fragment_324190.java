.method static public main : ([Ljava/lang/String;)V
    .limit stack 2
    .limit locals 7
    .catch java/lang/Throwable from L26 to L30 using L33
    .catch java/lang/Throwable from L13 to L18 using L51
    .catch [0] from L13 to L18 using L59
    .catch java/lang/Throwable from L69 to L73 using L76
    .catch [0] from L51 to L61 using L59
    .catch java/io/IOException from L3 to L94 using L97
    ldc 'before'
    astore_1
L3:
    new java/io/CharArrayWriter
    dup
    invokespecial java/io/CharArrayWriter <init> ()V
    astore_2
    aconst_null
    astore_3
L13:
    aload_2
    aconst_null
    invokevirtual java/io/CharArrayWriter writeTo (Ljava/io/Writer;)V
L18:
    aload_2
    ifnull L94
    aload_3
    ifnull L44
L26:
    aload_2
    invokevirtual java/io/CharArrayWriter close ()V
L30:
    goto L94
L33:
.stack full
    locals Object [Ljava/lang/String; Object java/lang/String Object java/io/CharArrayWriter Object java/lang/Throwable
    stack Object java/lang/Throwable
.end stack
    astore 4
    aload_3
    aload 4
    invokevirtual java/lang/Throwable addSuppressed (Ljava/lang/Throwable;)V
    goto L94
L44:
.stack same
    aload_2
    invokevirtual java/io/CharArrayWriter close ()V
    goto L94
L51:
.stack same_locals_1_stack_item
    stack Object java/lang/Throwable
.end stack
    astore 4
    aload 4
    astore_3
    aload 4
    athrow
L59:
.stack same_locals_1_stack_item
    stack Object java/lang/Throwable
.end stack
    astore 5
L61:
    aload_2
    ifnull L91
    aload_3
    ifnull L87
L69:
    aload_2
    invokevirtual java/io/CharArrayWriter close ()V
L73:
    goto L91
L76:
.stack full
    locals Object [Ljava/lang/String; Object java/lang/String Object java/io/CharArrayWriter Object java/lang/Throwable Top Object java/lang/Throwable
    stack Object java/lang/Throwable
.end stack
    astore 6
    aload_3
    aload 6
    invokevirtual java/lang/Throwable addSuppressed (Ljava/lang/Throwable;)V
    goto L91
L87:
.stack same
    aload_2
    invokevirtual java/io/CharArrayWriter close ()V
L91:
.stack same
    aload 5
    athrow
L94:
.stack full
    locals Object [Ljava/lang/String; Object java/lang/String
    stack 
.end stack
    goto L108
L97:
.stack same_locals_1_stack_item
    stack Object java/io/IOException
.end stack
    astore_2
    getstatic java/lang/System out Ljava/io/PrintStream;
    aload_2
    invokevirtual java/io/IOException getMessage ()Ljava/lang/String;
    invokevirtual java/io/PrintStream println (Ljava/lang/String;)V
L108:
.stack same
    ldc 'after'
    astore_2
    return
.end method
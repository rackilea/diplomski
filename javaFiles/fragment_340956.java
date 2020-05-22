getstatic java/lang/System/in Ljava/io/InputStream;
invokevirtual java/io/InputStream/read()I
istore_1
getstatic java/lang/System/out Ljava/io/PrintStream;            :label1
ldc "a"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
iload_1
ifle <label2>
goto <label3>
getstatic java/lang/System/out Ljava/io/PrintStream;            :label2
ldc "b"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
goto <label1>
return                                                          :label3
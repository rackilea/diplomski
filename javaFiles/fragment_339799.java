public static void main(java.lang.String[]);
Code:
0:  aconst_null
1:  astore_1
2:  getstatic   #16; //Field java/lang/System.out:Ljava/io/PrintStream;
5:  new #22; //class java/lang/StringBuilder
8:  dup
9:  invokespecial   #24; //Method java/lang/StringBuilder."<init>":()V
12: aload_1                                                    <--- closest line in the line number table
13: invokevirtual   #25; //Method java/lang/String.toLowerCase:()Ljava/lang/String;       <--- NPE here
16: invokevirtual   #31; //Method java/lang/StringBuilder.append:      (Ljava/lang/String;)Ljava/lang/StringBuilder;
19: invokevirtual   #35; //Method java/io/PrintStream.println:(Ljava/lang/Object;)V
22: return
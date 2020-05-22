public static java.lang.String concat(java.lang.String, java.lang.String);
  Code:
   0:   new     #2; //class java/lang/StringBuffer
   3:   dup
   4:   invokespecial   #3; //Method java/lang/StringBuffer."<init>":()V
   7:   aload_0
   8:   invokevirtual   #4; //Method java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
   11:  aload_1
   12:  invokevirtual   #4; //Method java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
   15:  invokevirtual   #5; //Method java/lang/StringBuffer.toString:()Ljava/lang/String;
   18:  areturn
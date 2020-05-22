0:   ldc2_w  #16; //double 0.0010d
3:   dstore_1
4:   getstatic       #18; //Field java/lang/System.out:Ljava/io/PrintStream;
7:   new     #24; //class java/lang/StringBuilder
10:  dup
11:  ldc     #26; //String pre-init:
13:  invokespecial   #28; //Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
16:  dload_1
17:  invokevirtual   #31; //Method java/lang/StringBuilder.append:(D)Ljava/lang/StringBuilder;
20:  invokevirtual   #35; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
23:  invokevirtual   #39; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
26:  return
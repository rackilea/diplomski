0:   new     #2; //class java/lang/StringBuilder
  3:   dup
  4:   invokespecial   #3; //Method java/lang/StringBuilder."<init>":()V
  7:   ldc     #4; //String
  9:   invokevirtual   #5; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
  12:  aload_0
  13:  arraylength
  14:  invokevirtual   #6; //Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
  17:  invokevirtual   #7; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
  20:  astore_1
  21:  return
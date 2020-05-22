0:   ldc     #2; //String Four4
   2:   astore_1
   3:   iconst_4
   4:   istore_2
   5:   new     #3; //class java/lang/StringBuilder
   8:   dup
   9:   invokespecial   #4; //Method java/lang/StringBuilder."<init>":()V
   12:  ldc     #5; //String Four
   14:  invokevirtual   #6; //Method java/lang/StringBuilder.append:(Ljava/lang/
String;)Ljava/lang/StringBuilder;
   17:  iload_2
   18:  invokevirtual   #7; //Method java/lang/StringBuilder.append:(I)Ljava/lan
g/StringBuilder;
   21:  invokevirtual   #8; //Method java/lang/StringBuilder.toString:()Ljava/la
ng/String;
   24:  astore_3
   25:  return
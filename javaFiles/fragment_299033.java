static void combined();
  Code:
   0:   ldc #2; //String hello
   2:   astore_0
   3:   aload_0
   4:   invokevirtual   #3; //Method java/lang/String.toString:()Ljava/lang/String;
   7:   invokestatic    #4; //Method foo:(Ljava/lang/String;)V
   10:  return

static void separate();
  Code:
   0:   ldc #2; //String hello
   2:   astore_0
   3:   aload_0
   4:   invokevirtual   #3; //Method java/lang/String.toString:()Ljava/lang/String;
   7:   astore_1
   8:   aload_1
   9:   invokestatic    #4; //Method foo:(Ljava/lang/String;)V
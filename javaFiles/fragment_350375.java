0: new    #3; //class GenericHolder
  3: dup
  4: invokespecial  #4; //Method GenericHolder."<init>":()V
  7: astore_1
  8: aload_1
  9: iconst_5
 10: invokestatic   #5; //Method java/lang/Integer.valueOf:(I)
 13: invokevirtual  #6; //Method GenericHolder.set:(Ljava/lang/Object;)V
 16: aload_1
 17: invokevirtual  #7; //Method GenericHolder.get:()Ljava/lang/Object;
 20: checkcast  #8; //class java/lang/Integer
 23: astore_2
 24: return
public Clazz methodA(int[]);
  Code:
   0:   new #5; //class Clazz
   3:   dup
   4:   invokespecial   #6; //Method "<init>":()V
   7:   astore_2
   8:   aload_0
   9:   getfield    #4; //Field t:[Ljava/lang/Object;
   12:  arraylength
   13:  aload_2
   14:  getfield    #4; //Field t:[Ljava/lang/Object;
//BELOW is the line that will fail
   17:  checkcast   #7; //class "[Ljava/lang/Integer;"
   20:  arraylength
   21:  isub
   22:  newarray int
   24:  astore_3
   25:  aload_0
   26:  areturn
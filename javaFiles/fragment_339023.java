public void constEqVar(java.lang.String);
  Code:
   0:   getstatic       #2; //Field CONST:Ljava/lang/String;
   3:   aload_1
   4:   invokevirtual   #3; //Method java/lang/String.equals:(Ljava/lang/Object;)Z
   7:   pop
   8:   return

public void varEqConst(java.lang.String);
  Code:
   0:   aload_1
   1:   getstatic       #2; //Field CONST:Ljava/lang/String;
   4:   invokevirtual   #3; //Method java/lang/String.equals:(Ljava/lang/Object;)Z
   7:   pop
   8:   return
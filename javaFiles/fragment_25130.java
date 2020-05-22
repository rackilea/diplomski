private EnclosingClass getEnclosingOfEnclosing();
  Code:
     0: aload_0
     1: getfield      #1                  // Field this$1:LEnclosingClass$InnerClass;
     4: getfield      #3                  // Field EnclosingClass$InnerClass.this$0:LEnclosingClass;
     7: areturn
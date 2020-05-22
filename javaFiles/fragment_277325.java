public static void main(java.lang.String[]) throws java.lang.Exception;
    Code:
       0: new           #2  // class java/util/ArrayList
       3: dup
       4: invokespecial #3  // Method java/util/ArrayList."<init>":()V
       7: invokestatic  #4  // Method castArrayList:(Ljava/util/ArrayList;)Ljava/util/List;
      // Cast is done here, after returning
      10: checkcast     #2  // class java/util/ArrayList
      13: astore_1
      14: return

  public static <L extends java.util.List> L castArrayList(java.util.ArrayList);
    Code:
       0: aload_0
       // No 'checkcast' here
       1: areturn
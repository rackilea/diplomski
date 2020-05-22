public static void extraReference();
    Code:
       0: new           #2                  // class java/lang/String
       3: dup           
       4: invokespecial #3                  // Method java/lang/String."<init>":()V
       7: astore_0      
       8: getstatic     #4                  // Field list:Ljava/util/List;
      11: aload_0       
      12: invokeinterface #5,  2            // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
      17: pop           
      18: return        

  public static void noReference();
    Code:
       0: getstatic     #4                  // Field list:Ljava/util/List;
       3: new           #2                  // class java/lang/String
       6: dup           
       7: invokespecial #3                  // Method java/lang/String."<init>":()V
      10: invokeinterface #5,  2            // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
      15: pop           
      16: return
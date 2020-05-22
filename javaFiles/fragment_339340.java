0: new           #2                  // class java/util/ArrayList
 3: dup
 4: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
 7: astore_1
 8: aload_1
 9: new           #4                  // class java/lang/Object
12: dup
13: invokespecial #1                  // Method java/lang/Object."<init>":()V
16: invokeinterface #5,  2            // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
21: pop
22: aload_1
23: astore_2
24: aload_2
25: iconst_0
26: invokeinterface #6,  2            // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
31: checkcast     #7                  // class "[Ljava/lang/Object;"
34: invokevirtual #8                  // Method java/lang/Object.toString:()Ljava/lang/String;
37: pop
38: return
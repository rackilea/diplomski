public boolean equals(java.lang.Object);
   Code:
      0: aload_1
      1: instanceof    #13                 // class sov/Test
      4: ifeq          62
      7: aload_1
      8: checkcast     #13                 // class sov/Test
     11: getfield      #3                  // Field a:Ljava/lang/String;
     14: aload_0
     15: getfield      #3                  // Field a:Ljava/lang/String;
     18: invokevirtual #14                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
     21: ifeq          62
     24: aload_1
     25: checkcast     #13                 // class sov/Test
     28: getfield      #7                  // Field b:Ljava/lang/Integer;
     31: aload_0
     32: getfield      #7                  // Field b:Ljava/lang/Integer;
     35: invokevirtual #15                 // Method java/lang/Integer.equals:(Ljava/lang/Object;)Z
     38: ifeq          62
     41: aload_1
     42: checkcast     #13                 // class sov/Test
     45: getfield      #12                 // Field c:Ljava/lang/Long;
     48: aload_0
     49: getfield      #12                 // Field c:Ljava/lang/Long;
     52: invokevirtual #16                 // Method java/lang/Long.equals:(Ljava/lang/Object;)Z
     55: ifeq          62
     58: iconst_1
     59: goto          63
     62: iconst_0
     63: ireturn
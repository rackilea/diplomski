public static void main(java.lang.String[]);
Code:
   0: getstatic     #20                 // Field cell:Lp2/Cell;
   3: ldc           #22                 // String a
   5: invokevirtual #24                 // Method p2/Cell.set:(Ljava/lang/Object;)V
   8: getstatic     #20                 // Field cell:Lp2/Cell;
  11: invokevirtual #30                 // Method p2/Cell.get:()Ljava/lang/Object;
  14: checkcast     #34                 // class java/lang/String
  17: astore_1      
  18: getstatic     #36                 // Field java/lang/System.out:Ljava/io/PrintStream;
  21: aload_1       
  22: invokevirtual #42                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
  25: return        
}
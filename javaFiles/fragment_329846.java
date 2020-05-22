public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=5, locals=3, args_size=1
         0: ldc2_w        #14                 // long 2l
         3: lstore_1      
         4: lload_1       
         5: ldc2_w        #14                 // long 2l
         8: lmul          
         9: lstore_1      
        10: getstatic     #21                 // Field java/lang/System.out:Ljava/io/PrintStream;
        13: lload_1       
        14: invokevirtual #27                 // Method java/io/PrintStream.println:(J)V
        17: return        
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      17     1     i   J
            0      17     0  args   [Ljava/lang/String;
    MethodParameters:
      Name                           Flags
      args
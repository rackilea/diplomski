public static void main(java.lang.String...);
  Code:
     0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     3: invokestatic  #10                 // Method a:()Ljava/lang/String;
     6: invokestatic  #11                 // Method b:()Ljava/lang/String;
     9: invokestatic  #12                 // Method c:()I
    12: invokestatic  #13                 // Method d:()I
    15: imul
    16: invokedynamic #14,  0             // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    21: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
    24: return
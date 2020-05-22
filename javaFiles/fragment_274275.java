public java.lang.String getTestMessageB();
    Code:
       0: new           #3                  // class java/lang/StringBuffer
       3: dup           
       4: ldc           #4                  // String Hello
       6: invokespecial #5                  // Method java/lang/StringBuffer."<init>":(Ljava/lang/String;)V
       9: ldc           #6                  // String World..!
      11: invokevirtual #7                  // Method java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
      14: invokevirtual #8                  // Method java/lang/StringBuffer.toString:()Ljava/lang/String;
      17: areturn
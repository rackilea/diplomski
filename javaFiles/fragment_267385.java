0: aload_0       
       1: getfield      #7                  // Field textView:Landroid/widget/TextView;
       4: aload_0       
       5: getfield      #4                  // Field editText:Landroid/widget/EditText;
       8: invokevirtual #8                  // Method android/widget/EditText.getText:()Landroid/text/Editable;
      11: invokevirtual #9                  // Method java/lang/Object.toString:()Ljava/lang/String;
      14: invokevirtual #10                 // Method java/lang/String.trim:()Ljava/lang/String;
      17: invokevirtual #11                 // Method java/lang/String.toLowerCase:()Ljava/lang/String;
      20: invokevirtual #12                 // Method android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
      23: return
String str1 = "??56??77??";
    String pattern = "";
    for(int i = 0; i < str1.length(); i++){
      char b = str1.charAt(i);
      if (b == '?') {
        pattern += "[0-9]";
      } else {
        pattern += "["+b+"?]";
      }
    }
    System.out.print(pattern);
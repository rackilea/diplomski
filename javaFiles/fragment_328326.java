public static String formattedString(char[] c, int len1, char[] d, int len2, char[] e, int len3) {
    char[] charlist = new char[len1];
    for (int i = 0; i < len1; i++) {
      if (c.length == len1 || c.length > len1) {
        charlist[i] = (c[i]);
      } else if (c.length < len1) { // <--here
        if (c.length > i)
          charlist[i] = (c[i]);
        else
          charlist[i] = ' ';
      } else {
        charlist[i] = '#';
      }
    }
    char[] charlist2 = new char[len2];

    for (int i = 0; i < len2; i++) {
      if (d.length == len2 || d.length > len2) {
        charlist2[i] = (d[i]);
      } else if (d.length < len2) {
        if (d.length > i)
          charlist2[i] = (d[i]);
        else
          charlist2[i] = ' ';
      } else {
        charlist2[i] = '#';
      }
    }
    char[] charlist3 = new char[len3];

    for (int i = 0; i < len3; i++) {
      if (e.length == len3 || e.length > len3) {
        charlist3[i] = (e[i]);
      } else if (e.length > i) { // <--here
        if (i < len3)
          charlist3[i] = (e[i]);
        else
          charlist3[i] = ' ';
      } else {
        charlist3[i] = '#';
      }
    }
    String s ="";
    int i = 0;
    for(char a : charlist){
      s += a;
    }
    for(char a : charlist2){
      s += a;
    }
    for(char a : charlist3){
      s += a;
    }

    return s+'\n';
  }
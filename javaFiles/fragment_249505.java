for(int i = 0; i < str.length-1; i++) {
    if(Integer.valueOf(str[i]) > 0) {
      for(int j = i; j < str.length-1; j++) {
        str[i] += '0';
      }
    }
  }
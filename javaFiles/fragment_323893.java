for (int i = 0; i < c.length - 1; i++) {
  for (int j = i; j < c.length; j++) {
    if (c[i] * c[j] >= c[i] + c[j]) {
       System.out.println('(' + c[i] + ',' + c[j] + ')');
    }
  }   
}
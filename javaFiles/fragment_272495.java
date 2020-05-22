for(int i=0;i<data.length;i++){
StringTokenizer stringTokenizer = new StringTokenizer(data[i], ":");

  while (stringTokenizer.hasMoreTokens()) {
     ip[i]=stringTokenizer.nextToken();
     port[i]=stringTokenizer.nextToken();

  }
}
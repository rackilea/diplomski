StringBuffer b = new StringBuffer();
synchronized(b){
  for(int i = 0 ; i < 100; i++){
     b.append(i);
  }
}
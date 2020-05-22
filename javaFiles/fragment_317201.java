f.seek(3);
  f.write(key);
  byte[] new1 = new byte[(int)f.length()-3];
  int i=0;
  for(i=3;f.read()!=-1;i++){
          ^^^^^^^^
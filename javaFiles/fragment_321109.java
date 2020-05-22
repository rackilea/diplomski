char[] nkey = new char[16];
for (int i =0 ;i<16;++i) {
  nkey[i] = 65;
}

while (true) {
  //... do the stuff you do in the inner of the cycle
  int index = 15;  
  nkey[index]++;
  while (index >= 0 && nkey[index] >= 122) {
    nkey[index] = 65;
    index--;
    if (index < 0) {
      break;
    }
    nkey[index]++;
  }
}
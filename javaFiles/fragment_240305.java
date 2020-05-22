byte [] buf = new byte[7200];
int len = 7200;
int pos=0;

while(len > 0) {
  int rd = is.read(buf, pos, len);
  if(rd<0) {
      //premature EOF
      break;
  }
  pos += rd;
  len -= rd;
}
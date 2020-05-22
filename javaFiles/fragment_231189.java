char toChar(byte b1, byte b2) {
  char c1 = (char)b1;
  char c2 = (char)b2;
  if (c1<0) c1+=256;
  if (c2<0) c2+=256;
  return (char)((c1<<8)+c2);
}
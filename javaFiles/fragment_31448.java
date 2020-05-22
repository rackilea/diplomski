public byte bitsToByte(byte[] bits) {
  byte value = 0;
  for (byte b : bits) {
    value <<=1;
    value += b;
  }
  return value;
}
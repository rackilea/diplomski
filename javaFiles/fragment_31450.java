public static byte bitsToByte1(byte[] bits){
  byte result = 0;
  for (byte i = 0; i < bits.length; i++) {
    byte tmp = bits[i];
    tmp <<= i;             // Perform the left shift by "i" times. "i" position of the bit
    result |= tmp;         // perform the bit-wise OR 
  }
  return result;
}
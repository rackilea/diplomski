public static void main(String[] args) {
  BitsToByte bitsToByte = new BitsToByte();
  byte bits[] = new byte[]{0,0,1,0,1,1,0,1};  // 1 + 0 + 4 + 8 + 0 + 32 + 0 + 0
  byte value = bitsToByte.bitsToByte(bits);
  System.out.println(value);
}
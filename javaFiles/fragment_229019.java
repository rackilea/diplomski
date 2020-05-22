byte f = (byte)0b00101000;
// Bits 0 to 7   --5-3---                  
byte s = (byte)0b11111111;
// Bits 8 to 15  54321098
byte[] bytes = new byte[]{f, s};
BitSet bs = BitSet.valueOf(bytes);
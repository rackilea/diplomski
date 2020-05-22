byte[] bytes = new byte[8];

// set the byte array from smallest to largest byte
for(int i = 0; i < 8; ++i) {
    byte[i] = (your_long >> i*8) & 0xFF;
}

// build the new long from largest to smallest byte (reversed)
long l = ((buf[0] & 0xFFL) << 56) |
         ((buf[1] & 0xFFL) << 48) |
         ((buf[2] & 0xFFL) << 40) |
         ((buf[3] & 0xFFL) << 32) |
         ((buf[4] & 0xFFL) << 24) |
         ((buf[5] & 0xFFL) << 16) |
         ((buf[6] & 0xFFL) <<  8) |
         ((buf[7] & 0xFFL) <<  0) ;
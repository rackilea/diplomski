for (int i = 0; i < data.length; i += 2) {
  // Reconstruct 16 bit rgb565 value from two bytes
  int rgb565 = (data[i] & 255) | ((data[i + 1] & 255) << 8);

  // Extract raw component values (range 0..31 for g and b, 0..63 for g)  
  int b5 = rgb565 & 0x1f;
  int g6 = (rgb565 >> 5) & 0x3f;
  int r5 = (rgb565 >> 11) & 0x1f;

  // Scale components up to 8 bit: 
  // Shift left and fill empty bits at the end with the highest bits,
  // so 00000 is extended to 000000000 but 11111 is extended to 11111111
  int b = (b5 << 3) | (b5 >> 2);
  int g = (g6 << 2) | (g6 >> 4);
  int r = (r5 << 3) | (r5 >> 2); 

  // The rgb888 value, store in an array or buffer...
  int rgb = (r << 16) | (g << 8) | b;
}
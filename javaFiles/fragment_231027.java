int[] audio = new int[byteArray.length/2];
for (int i = 0; i < byteArray.length/2; i++) { // read in the samples
  int lsb = byteArray[i * 2 + 0] & 0xFF; // "least significant byte"
  int msb = byteArray[i * 2 + 1] & 0xFF; // "most significant byte"
  audio[i] = (msb << 8) + lsb;
}
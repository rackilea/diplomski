// Generate some data.
byte[] b = new byte[1024];
new Random().nextBytes(b);

// Simulate corruption of data by flipping the low 3 bits.
for (int i = 0; i < b.length; i++) {
  //b[i] ^= 0x1; // change one bit
  //b[i] ^= 0x3; // change two bits
  b[i] ^= 0x7; // change three bits
}
int[] bits = {0,1,0,1,1,1,1,0,0,0,1,1,1,1,0,1};
assert bits.length % 8 == 0;

byte[] bytes = new byte[bits.length / 8];
for (int i = 0; i < bytes.length; i++) {
    int b = 0;
    for (int j = 0; j < 8; j++)
        b = (b << 1) + bits[i * 8 + j];
    bytes[i] = (byte)b;
}

for (int i = 0; i < bytes.length; i++)
    System.out.printf("%02x ", bytes[i]); // prints: 5e 3d 
System.out.println();
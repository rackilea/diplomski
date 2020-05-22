byte[] data = ... // Read 4096 bytes
byte[][][] res = new byte[16][16][16];
for (int x = 0 ; x != 16 ; x++) {
    for (int y = 0 ; y != 16 ; y++) {
        for (int z = 0 ; z != 16 ; z++) {
            res[x][y][z] = data[16*16*x + 16*y + z];
        }
    }
}
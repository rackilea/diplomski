DataBufferUShort dataBuffer;
short[] data = dataBuffer.getData();

byte[] rgb = new byte[data.length * 3];

for (int i = 0; i < data.length; i++) {
    int shortRGB = data[i] & 0xffff;

    // Assuming 5 bit R, 5 bit G, 5 bit B, using the lower 15 bits
    rgb[i * 3 + 0] = ((((shortRGB & 0x7C00) >> 10) + 1) * 8) - 1;
    rgb[i * 3 + 1] = ((((shortRGB & 0x03E0) >>  5) + 1) * 8) - 1;
    rgb[i * 3 + 2] = ((((shortRGB & 0x001F)      ) + 1) * 8) - 1;
}
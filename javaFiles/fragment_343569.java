DataBufferUShort dataBuffer;
short[] data = dataBuffer.getData();

int[] argb = new byte[data.length / 4];

for (int i = 0; i < data.length; += 4) {
    int a = (data[i    ] & 0xff00) >> 8;
    int r = (data[i + 1] & 0xff00) >> 8;
    int g = (data[i + 2] & 0xff00) >> 8;
    int b = (data[i + 3] & 0xff00) >> 8;

    argb[i / 4] = a << 24 | r << 16 | g << 8 | b;
}
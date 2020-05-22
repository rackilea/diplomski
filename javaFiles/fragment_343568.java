DataBufferUShort dataBuffer;
short[] data = dataBuffer.getData();

byte[] gray = new byte[data.length];

for (int i = 0; i < data.length; i++) {
    gray[i] = (byte) ((data[i] & 0xff00) >> 8);
}
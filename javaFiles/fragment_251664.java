byte[] dataBytes = ....;
float floatArray[] = new float[dataBytes.length / Float.BYTES];
ByteBuffer dataBuffer = ByteBuffer.wrap(dataBytes)
    .order(ByteOrder.LITTLE_ENDIAN)
    .asFloatBuffer()
    .get(floatArray);
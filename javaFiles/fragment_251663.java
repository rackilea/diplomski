byte[] dataBytes = ...;

ByteBuffer dataBuffer = ByteBuffer.wrap(dataBytes);
dataBuffer.order(ByteOrder.LITTLE_ENDIAN);

FloatBuffer floatBuffer = dataBuffer.asFloatBuffer();
float floatArray[] = new float[dataBytes.length / Float.BYTES];
floatBuffer.get(floatArray);
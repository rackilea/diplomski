ByteBuffer bufferVTemp = ByteBuffer.allocateDirect(verticesList.size() * 2 * 4);
bufferVTemp.order(ByteOrder.nativeOrder());
verticesBufferTemp = bufferVTemp.asFloatBuffer();

ByteBuffer bufferTTemp = ByteBuffer.allocateDirect(textureList.size() * 2 * 4);
bufferTTemp.order(ByteOrder.nativeOrder());
textureBufferTemp = bufferTTemp.asFloatBuffer();

for(String vertex: verticesList) {
    String coords[] = vertex.split(" "); // Split by space
    float x = Float.parseFloat(coords[1]);
    float y = Float.parseFloat(coords[2]);
    float z = Float.parseFloat(coords[3]);
    verticesBufferTemp.put(x);
    verticesBufferTemp.put(y);
    verticesBufferTemp.put(z);
}
verticesBufferTemp.position(0);

for (String texture: textureList)
{
    String textureIndices[] = texture.split("\\s+");
    float texture1 = Float.parseFloat(textureIndices[1]);
    float texture2 = Float.parseFloat(textureIndices[2]);
    textureBufferTemp.put(texture1);
    textureBufferTemp.put(texture2);
}
textureBufferTemp.position(0);
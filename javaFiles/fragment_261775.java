ByteBuffer bufferV = ByteBuffer.allocateDirect(facesVertexBuffer.size() * 3 * 4);
bufferV.order(ByteOrder.nativeOrder());
verticesBuffer = bufferV.asFloatBuffer();

ByteBuffer bufferT = ByteBuffer.allocateDirect(facesVertexBuffer.size() * 2 * 4);
bufferT.order(ByteOrder.nativeOrder());
textureBuffer = bufferT.asFloatBuffer();

int size = facesVertexBuffer.remaining();
System.out.println("size " + size);
for(int i = 0; i < size;i++)
{
    int faceVertex = facesVertexBuffer.get(i);
    int faceTexture = facesTextureBuffer.get(i);

    float x = verticesBufferTemp.get((faceVertex)*2);
    float y = verticesBufferTemp.get(((faceVertex)*2)+1);
    float z = verticesBufferTemp.get(((faceVertex)*2)+1);
    verticesBuffer.put( i*3,    x);
    verticesBuffer.put( i*3+1,  y);
    verticesBuffer.put( i*3+2), z);

    float u = textureBufferTemp.get((faceTexture)*2);
    float v = -textureBufferTemp.get(((faceTexture)*2)+1);
    textureBuffer.put( i*2,   u);
    textureBuffer.put( i*2+1, v);
}
verticesBuffer.position(0);
textureBuffer.position(0);
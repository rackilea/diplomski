public void parseTexture()
{
    int size = facesVertexBuffer.remaining();
    System.out.println("size " + size);
    for(int i = 0; i < size;i++)
    {
        int faceVertex = facesVertexBuffer.get(i);
        int faceTexture = facesTextureBuffer.get(i);
        float a = textureBufferTemp.get((faceTexture)*2);
        float b = -textureBufferTemp.get(((faceTexture)*2)+1);
        textureBuffer.put((faceVertex*2),a);
        textureBuffer.put(((faceVertex)*2)+1,b);
   }
   textureBuffer.position(0);

   System.out.println("end parse texture");
}
public ByteBuffer convertToOne(ByteBuffer[] src)
{
    int size=0;
    for(int i = 0 ; i < src.length ; i++) {
        size+=src[i].array().length;
    }

    ByteBuffer newBuffer = ByteBuffer.allocate(size);

    int sizeAt = 0;
    for(int i = 0 ; i < src.length ; i++) {
        newBuffer.put(src[i].array(), sizeAt);
        sizeAt += src[i].array().length;
    }
    return newBuffer;
}
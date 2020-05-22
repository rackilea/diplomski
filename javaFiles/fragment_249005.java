while ((fileIChannel.read(byteBuffer) != -1 && byteBuffer.position() > 0)
{
    byteBuffer.flip();
    bytesTransferred += socketChannel.write(byteBuffer);
    byteBuffer.compact();
}
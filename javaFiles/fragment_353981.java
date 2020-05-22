ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 8);

ReadableByteChannel ich = Channels.newChannel(inputStream);
WritableByteChannel och = Channels.newChannel(outputStream);

while (ich.read(buffer) > -1 || buffer.position() > 0)
{
    buffer.flip();
    och.write(buffer);
    buffer.compact();
}   
ich.close();
och.close();
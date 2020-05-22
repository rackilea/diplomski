while (in.read(buffer) > 0 || buffer.position() > 0)
{
    buffer.flip();
    out.write(buffer);
    buffer.compact();
}
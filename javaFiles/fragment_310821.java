while (len<length)
{
    bytesRead = in.read(buffer, 0, (int)Math.min(buffer.length, length-len));
    len = len + bytesRead;
    baos.write(buffer, 0, bytesRead);
}
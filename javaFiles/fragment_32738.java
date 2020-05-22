while ((bytes = input.Read(buffer, 0, BufferSize)) > 0)
{
    for (int i = 0; i < bytes; i += rijndael.BlockSize)
    {
        decryptor.TransformBlock(buffer, i, rijndael.BlockSize, buffer, i);
    }
    output.Write(buffer, 0, bytes);
}
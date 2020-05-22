public final byte[] encode(
    String text
    )
{
    ByteArrayOutputStream encodedStream = new ByteArrayOutputStream();
    try
    {
        for(int index = 0, length = text.length(); index < length; index++)
        {
            int textCode = text.charAt(index);
            byte[] charCode = codes.getKey(textCode).data;
            encodedStream.write(charCode);
            usedCodes.add(textCode);
        }
        encodedStream.close();
    }
    catch(IOException e)
    {throw new RuntimeException(e);}

    return encodedStream.toByteArray();
}
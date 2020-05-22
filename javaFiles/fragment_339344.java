private static void bulkAndChannel(String fileName, long longArray[]) 
{
    ByteBuffer bytes = 
        ByteBuffer.allocate(longArray.length * Long.BYTES);
    bytes.order(ByteOrder.nativeOrder()).asLongBuffer().put(longArray);
    try (FileOutputStream fos = new FileOutputStream(fileName))
    {
        fos.getChannel().write(bytes);
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
}
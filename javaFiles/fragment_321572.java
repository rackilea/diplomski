private String Decompress(String compressedText)
{

    byte[] compressed = compressedText.getBytes("UTF8");
    compressed = org.apache.commons.codec.binary.Base64.decodeBase64(compressed);
    byte[] buffer=new byte[compressed.length-4];
    buffer = copyForDecompression(compressed,buffer, 4, 0);
    final int BUFFER_SIZE = 32;
    ByteArrayInputStream is = new ByteArrayInputStream(buffer);
    GZIPInputStream gis = new GZIPInputStream(is, BUFFER_SIZE);
    StringBuilder string = new StringBuilder();
    byte[] data = new byte[BUFFER_SIZE];
    int bytesRead;
    while ((bytesRead = gis.read(data)) != -1) 
    {
        string.append(new String(data, 0, bytesRead));
    }
    gis.close();
    is.close();
    return string.toString();
}
private  byte[] copyForDecompression(byte[] b1,byte[] b2,int srcoffset,int dstoffset)
{       
    for(int i=0;i<b2.length && i<b1.length;i++)
    {
        b2[i]=b1[i+4];
    }
    return b2;
}
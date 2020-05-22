InputStream instream = mysocket.getInputStream();
BufferedInputStream bis = new BufferedInputStream(instream);

byte[] prefixArray = new byte[4];
DataInputStream dis = new DataInputStream(bis);
dis.readFully(prefixArray);
String prefix = new String(prefixArray);

if ("text".equals(prefix))
{
    InputStreamReader isr = new InputStreamReader(bis, "UTF-8"));
    //...
}
else
{
    byte[] barray = new byte[arraysize];
    do
    {
        numread = bis.read(barray, 0, arraysize);
        if (numread == -1) break;
        //...
    }
    while (true);
}
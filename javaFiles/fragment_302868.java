InputStream instream = mysocket.getInputStream();

byte[] prefixArray = new byte[4];
int offset = 0;
int numread;
do
{
    numread = instream.read(prefixArray, offset, 4-offset);
    if (numread == -1) return;
    offset += numread;
}
while (offset < 4);
String prefix = new String(prefixArray);

if ("text".equals(prefix))
{
    BufferedReader br = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
    //...
}
else
{
    byte[] barray = new byte[arraysize];
    // consider using BufferedInputStream here ...
    do
    {
        numread = instream.read(barray, 0, arraysize);
        if (numread == -1) break;
        //...
    }
    while (true);
}
String toParse = "ObjectGUId=1abcde&ObjectType=2&ObjectTitle=maximumoflife&Content=racroi&TimeStamp=2012-11-05T17:20:06.056";
String[] fields = toParse.split("&");
String[] kv;

HashMap<String, String> things = new HashMap<String, String>();


for (int i = 0; i < fields.length; ++i)
{
    t = fields[i].split("=");
    if (2 == kv.length)
    {
        things.put(kv[0], kv[1]); 
    }
}
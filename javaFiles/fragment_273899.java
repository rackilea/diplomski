String purge[] = {"http://", "https://", "ftp://", "www."}; //order is important!
String result = url;
for (int i = 0; i < purge.length; ++i)
{
    if (result.startsWith(purge[i])
    {
        result = result.substring(purge[i].length);
    }
}
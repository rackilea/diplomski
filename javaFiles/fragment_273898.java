String purge[] = {"www.", "http://", "https://", "ftp://"};
String result = url;
for (int i = 0; i < purge.length; ++i)
{
    result = result.replace(purge[i], "");
}
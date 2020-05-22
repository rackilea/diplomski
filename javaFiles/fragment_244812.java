int count;
byte[] buffer = new byte[8192];
while ((count = instream.read(buffer)) > 0)
{
    // ...
    // for example:
    out.write(buffer, 0, count);
}
byte[] buffer = new byte[8192];  // or whatever you like, anything above zero. Note that it doesn't have to be the size of the file
int count;
while ((count = in.read(buffer)) > 0)
{
    out.write(buffer, 0, count);
}
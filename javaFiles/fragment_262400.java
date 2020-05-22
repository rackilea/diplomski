char[] buffer = new char[8192];
int count;
while ((count = inputStream.read(buffer)) > 0)
{
    outputStream.write(buffer, 0, count);
}
int count;
char charBuffer = new char[8192];
FileReader reader = new FileReader(...);
while ((count = reader.read(charBuffer)) > 0)
{
    buffer.append(charBuffer, 0, count);
}
reader.close();
BufferedInputStream in = new BufferedInputStream(url).openStream())
byte data[] = new byte[1024];
int count;
while((count = in.read(data,0,1024)) != -1)
{
    out.write(data, 0, count);
}
byte[] buffer = new byte[8192]; // or more, or even less, anything > 0
int count;
while ((count = in.read(buffer)) > 0)
{
    out.write(buffer, 0, count);
}
out.close();
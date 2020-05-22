byte[] buffer = new byte[8192]; // any size greater than 0 will work
int count;
while ((count = in,read(buffer)) > 0)
{
    out.write(buffer, 0, count);
}
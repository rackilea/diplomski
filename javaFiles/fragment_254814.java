int count;
byte[] buffer = new byte[8192]; // or whatever you like really, not too small
while ((count = in.read(buffer)) > 0)
{
   out.write(buffer, 0, count);
}
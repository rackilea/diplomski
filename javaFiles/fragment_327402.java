while ((count = in.read(buffer)) > 0)
{
   out.write(buffer, 0, count);
   // or
   String s = new String(buffer, 0, count);
   // or whatever else you want.
}
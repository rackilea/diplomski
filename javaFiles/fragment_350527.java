while(!isCancel)
{
  int n = fileIn.read(b);
  if (n < 0)
    break;
  num += n;
  Log.info(num + "WRITTEN");
  z.write(b, 0, n);
}
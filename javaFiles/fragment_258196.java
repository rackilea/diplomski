byte[] toBytes(int i)
{
  byte[] result = new byte[4];

  result[0] = (byte) (i >> 24);
  result[1] = (byte) (i >> 16);
  result[2] = (byte) (i >> 8);
  result[3] = (byte) (i /*>> 0*/);

  return result;
}
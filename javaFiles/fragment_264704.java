public byte[] BitMapToByteArray(Bitmap map)
{
   ByteArrayOutputStream baos = new ByteArrayOutputStream();
   map.compress(Bitmap.CompressFormat.PNG, 100, baos);
   return baos.toByteArray();
}
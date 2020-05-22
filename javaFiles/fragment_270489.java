try (ByteArrayOutputStream buffer = new ByteArrayOutputStream())
{
   try (DeflaterOutputStream stream = new DeflaterOutputStream(buffer))
   {
      stream.write(testdata);
   }
   compressed = buffer.toByteArray();
   System.out.println("Compressed data: " + Arrays.toString(compressed));
}
catch (IOException e)
{
   System.out.println("IOException during compression.");
}
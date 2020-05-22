public static byte[] encStage1(String str) throws IOException
{
   try (ByteArrayOutputStream out = new ByteArrayOutputStream())
   {
       try (GZIPOutputStream gzip = new GZIPOutputStream(out))
       {
           gzip.write(str.getBytes(StandardCharsets.UTF_8));
       }
       return out.toByteArray();
       //return out.toString(StandardCharsets.ISO_8859_1);
       // Some single byte encoding
   }
}

public static String decStage3(byte[] str) throws IOException
{
   ByteArrayOutputStream baos = new ByteArrayOutputStream();
   try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(str)))
   {
       int b;
       while ((b = gis.read()) != -1) {
           baos.write((byte) b);
       }
   }
   return new String(baos.toByteArray(), StandardCharset.UTF_8);
}
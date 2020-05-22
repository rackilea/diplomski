public static void pipeStream(InputStream input, OutputStream output)
   throws IOException
{
   byte buffer[] = new byte[1024];
   int numRead = 0;

   do
   {
      numRead = input.read(buffer);
      output.write(buffer, 0, numRead);
   } while (input.available() > 0);

   output.flush();
}

public static void main(String[] argv)
{
   FileInputStream fileIn = null;
   FileOutputStream fileOut = null;

   OutputStream procIn = null;
   InputStream procOut = null;

   try
   {
      fileIn = new FileInputStream("test.txt");
      fileOut = new FileOutputStream("testOut.txt");

      Process process = Runtime.getRuntime().exec ("/bin/cat");
      procIn = process.getOutputStream();
      procOut = process.getInputStream();

      pipeStream(fileIn, procIn);
      pipeStream(procOut, fileOut);
   }
   catch (IOException ioe)
   {
      System.out.println(ioe);
   }
}
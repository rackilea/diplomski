void copyBufferedFile(BufferedInputStream bufferedInputStream,
                      BufferedOutputStream bufferedOutputStream)
         throws IOException 
{
    try (BufferedInputStream in = bufferedInputStream;
         BufferedOutputStream out = bufferedOutputStream) 
    {
        byte[] buf = new byte[1024];
        int nosRead;
        while ((nosRead = in.read(buf)) != -1)  // read this carefully ...
        {
            out.write(buf, 0, nosRead);
        }
    }
}
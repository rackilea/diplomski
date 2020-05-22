public class LimitInputStream extends FilterInputStream
{
   private int bytesRead;
   private int limit;
   /** Reads up to limit bytes from in */
   public LimitInputStream(InputStream in, int limit) {
      super(in);
      this.limit = limit;
   }

   public int read(byte[] data, int offs, int len) throws IOException {
      if (len==0) return 0; // read() contract mandates this
      if (bytesRead==limit)
         return -1;
      int toRead = Math.min(limit-bytesRead, len);
      int actuallyRead = super.read(data, offs, toRead);
      if (actuallyRead==-1)
          throw new UnexpectedEOFException();
      bytesRead += actuallyRead;
      return actuallyRead;
   }

   // similarly for the other read() methods

   // don't propagate to underlying stream
   public void close() { }
}
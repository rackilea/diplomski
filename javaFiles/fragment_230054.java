class DownloadManagerImpl implements DownloadManager
{
   public InputStream registerDownload(InputStream in)
   {
       return new ManagedDownloadStream(in);
   }

   void read(ManagedDownloadStream source, byte[] b, int offset, int len)
   {
      // all your streams now call this method.
      // You can decide how much data to actually read.
      int allowed = getAllowedDataRead(source, len);
      int read = source.actuallyRead(b, offset, len);
      recordBytesRead(read);  // update counters for number of bytes read
   }
}
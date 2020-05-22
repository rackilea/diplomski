public class ManagedBandwidthStream extends InputStream
   {
      private DownloadManagerImpl owner;

      public ManagedBandwidthStream(
            InputStream original,
            DownloadManagerImpl owner
         )
      {
         super(original);
         this.owner = owner;
      }

      public int read(byte[] b, int offset, int length)
      {
          owner.read(this, b, offset, length);
      }

      // used by DownloadManager to actually read from the stream
      int actuallyRead(byte[] b, int offset, int length)
      {
          super.read(b, offset, length);
      }

      // also override other read() methods to delegate to the read() above
   }
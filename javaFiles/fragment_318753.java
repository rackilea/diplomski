public class StreamCounter {

   private final InputStream in;
   private long bytesRead;

   public int read() {
     int nextByte = in.read();
     if (nextByte != -1) bytesRead++;
     return nextByte;
   }
}
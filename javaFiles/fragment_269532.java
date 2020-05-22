import java.io.IOException;
import java.io.Reader;

public class CustomReader extends Reader { // FIXME: choose a better name

   native byte[] native_call(); // Your JNI code here

   @Override public int read( char[] cbuf, int off, int len ) throws IOException {
      if( this.buffer == null ) {
         return -1;
      }
      final int count = len - off;
      int remaining = count;
      do {
         while( remaining > 0 && this.index < this.buffer.length ) {
            cbuf[off++] = (char)this.buffer[this.index++];
            --remaining;
         }
         if( remaining > 0 ) {
            this.buffer = native_call(); // Your JNI code here
            this.index  = 0;
         }
      } while( this.buffer != null && remaining > 0 );
      return count - remaining;
   }

   @Override
   public void close() throws IOException {
      // FIXME: release hardware resources
   }

   private int     index  = 0;
   private byte[]  buffer = native_call();

}
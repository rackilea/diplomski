// In this design, the C++ object needs to be explicitly destroyed by calling
// close() on the Java side.
// I think that Eclipse, at least, is configured by default to complain
// if an AutoCloseable is never close()d.
public class RFEthernetDetector implements AutoCloseable {
   private final long cxxThis; // using the "store pointers as longs" convention
   private boolean closed = false;
   public RFEthernetDetector(int port) {
       cxxThis = cxxConstruct(port);
   };
   @Override
   public void close() {
       if(!closed) {
           cxxDestroy(cxxThis);
           closed = true;
       }
   }
   private static native long cxxConstruct(int port);
   private static native void cxxDestroy(long cxxThis);

   // Works fine as a safety net, I suppose...
   @Override
   @Deprecated
   protected void finalize() {
       close();
   }
}
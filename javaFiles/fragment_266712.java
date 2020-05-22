public class Locking {
   public static void main(String arsg[])
       throws IOException {
     RandomAccessFile raf =
       new RandomAccessFile("junk.dat", "rw");
     FileChannel channel = raf.getChannel();
     FileLock lock = channel.lock();
     try {
       System.out.println("Got lock!!!");
       System.out.println("Press ENTER to continue");
       System.in.read(new byte[10]);
     } finally {
       lock.release();
     }
   }
}
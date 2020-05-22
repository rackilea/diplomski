import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileUtils {

    static final int CHUNK_SIZE = 8 * 1024;

    public static long getLastLinePosition(String name) throws IOException {
        FileChannel inChannel = null;
        FileLock lock = null;
        try {
            inChannel = new RandomAccessFile(name, "r").getChannel();
            lock = inChannel.tryLock(0, Long.MAX_VALUE, true);

            // ...

        } finally {
            if (lock != null) {
                lock.release();
            }
            if (inChannel != null) {
                inChannel.close();
            }
        }
        return 0;
    }

}
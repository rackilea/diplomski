import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileUtils {

    static final int CHUNK_SIZE = 8 * 1024;

    public static long getLastLinePosition(Path path) throws IOException {
        try (FileChannel inChannel = FileChannel.open(path, StandardOpenOption.READ);
             @SuppressWarnings("unused")
             FileLock lock = inChannel.tryLock(0, Long.MAX_VALUE, true)) {
            long fileSize = inChannel.size();
            long mark = fileSize;
            long position;
            boolean ignoreCR = false;
            while (mark > 0) {
                position = Math.max(0, mark - CHUNK_SIZE);

                MappedByteBuffer mbb = inChannel.map(FileChannel.MapMode.READ_ONLY, position, Math.min(mark, CHUNK_SIZE));
                byte[] bytes = new byte[mbb.remaining()];
                mbb.get(bytes);

                for (int i = bytes.length - 1; i >= 0; i--, mark--) {
                    switch (bytes[i]) {
                        case '\n':
                            if (mark < fileSize) {
                                return mark;
                            }
                            ignoreCR = true;
                            break;
                        case '\r':
                            if (ignoreCR) {
                                ignoreCR = false;
                            } else if (mark < fileSize) {
                                return mark;
                            }
                            break;
                    }
                }

                mark = position;
            }
        }
        return 0;
    }

}
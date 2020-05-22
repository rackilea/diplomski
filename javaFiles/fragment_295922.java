import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            final GZIPOutputStream gzip = new GZIPOutputStream(System.out);
            Throwable gzipEx = null;
            try {
                gzip.write("TEST".getBytes("UTF-8"));
            } catch (Throwable t) {
                gzipEx = t;
                throw t;
            } finally {
                if (gzip != null) {
                    if (gzipEx != null) {
                        try {
                            gzip.close();
                        } catch (Throwable t) {
                            gzipEx.addSuppressed(t);
                        }
                    } else {
                        gzip.close();
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
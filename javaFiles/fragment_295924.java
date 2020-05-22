import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class TryCatchFinally2 {
    public static void main(String[] args) {
        try {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Throwable baosEx = null;
            try {
                final GZIPOutputStream gzip = new GZIPOutputStream(baos);
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
            } catch (Throwable t) {
                baosEx = t;
                throw t;
            } finally {
                if (baos != null) {
                    if (baosEx != null) {
                        try {
                            baos.close();
                        } catch (Throwable t) {
                            baosEx.addSuppressed(t);
                        }
                    } else {
                        baos.close();
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
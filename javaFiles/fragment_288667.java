import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

public class MysqlTest {
    public static void main(String[] args) throws Exception {
        Process p = new ProcessBuilder("mysqldump", "-u", "error", "-p123456", "erp_sys").start();
        ByteArrayOutputStream dmp = new ByteArrayOutputStream();
        // Use FileOutputStream dmp = ... in real cases.
        Thread t1 = copyStreamsInBackground(p.getInputStream(), dmp);
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        Thread t2 = copyStreamsInBackground(p.getErrorStream(), err);
        t1.join();
        t2.join();
        int exitCode = p.waitFor();
        if (exitCode != 0) {
            System.err.println("Exit code: " + exitCode);
            String errors = new String(err.toByteArray(), Charset.forName("utf-8"));
            System.err.println(errors);
        } else {
            System.out.println("Exit code: " + exitCode);
            String dumps = new String(dmp.toByteArray(), Charset.forName("utf-8"));
            System.out.println(dumps);
        }
    }

    private static Thread copyStreamsInBackground(final InputStream is, final OutputStream os) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    IOUtils.copy(is, os);
                    os.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new IllegalStateException(ex);
                }
            }
        });
        t.start();
        return t;
    }
}
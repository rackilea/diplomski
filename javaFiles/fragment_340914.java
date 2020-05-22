import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class Runs_An_Exe {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("c:/cygwin/tmp/a.exe");
        pb.redirectErrorStream(true); // redirect stderr to stdin
        Process p = pb.start();

        final StringWriter writer = new StringWriter();
        final InputStreamReader isr = new InputStreamReader(p.getInputStream());
        // capture all output from the process
        new Thread(new Runnable() {
            @Override public void run() {
                readAll(isr, writer);
            }
        }).start();
        // wait for it to finish, and display the exit code
        int result = p.waitFor();
        System.out.println("result: " + result);
        // display any output from the process
        System.out.println(writer.toString());
    }

    private static void readAll(Reader reader, Writer writer) {
        try {
            char[] buffer = new char[8192];
            int n = 0;
            while (-1 != (n = reader.read(buffer))) {
                writer.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
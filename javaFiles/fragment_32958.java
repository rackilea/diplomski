import java.io.IOException;
import java.io.InputStream;

public class TestProcessBuilder {

    public static void main(String[] args) {

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
            pb.redirectError();
            Process p = pb.start();
            InputStreamConsumer isc = new InputStreamConsumer(p.getInputStream());
            isc.start();
            int exitCode = p.waitFor();

            isc.join();
            System.out.println("Process terminated with " + exitCode);
        } catch (IOException | InterruptedException exp) {
            exp.printStackTrace();
        }

    }

    public static class InputStreamConsumer extends Thread {

        private InputStream is;

        public InputStreamConsumer(InputStream is) {
            this.is = is;
        }

        @Override
        public void run() {

            try {
                int value = -1;
                while ((value = is.read()) != -1) {
                    System.out.print((char)value);
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }

        }

    }
}
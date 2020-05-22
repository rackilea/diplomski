import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestProcess {

    public static void main(String[] args) {
        String filename = "test.tx";
        String test = "grep \"\">\"\" "+filename+" | wc -l";
        System.out.println(test);

        try {
            ProcessBuilder pb = new ProcessBuilder("sh", "-c", test);
            pb.redirectError();
            Process p = pb.start();
            new Thread(new Consumer(p.getInputStream())).start();

            int ec = p.waitFor();
            System.out.println("ec: " + ec);
        } catch (IOException | InterruptedException exp) {
            exp.printStackTrace();
        }
    }

    public static class Consumer implements Runnable {

        private InputStream is;

        public Consumer(InputStream is) {
            this.is = is;
        }

        @Override
        public void run() {
            try (BufferedReader reader =  new BufferedReader(new InputStreamReader(is))){
                String value = null;
                while ((value = reader.readLine()) != null) {
                    System.out.println(value);
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

    }

}
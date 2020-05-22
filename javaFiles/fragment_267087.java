package snippet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessOutput {

    public static void main(String[] args) throws IOException, InterruptedException {
        final Process p = Runtime.getRuntime().exec("ls -lR");

        final BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        new Thread(new Runnable() {
            @Override public void run() {
                try {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException ex) {
                }
            }
        }).start();

        int waitFor = p.waitFor();
        System.out.println(waitFor + " is the return");
    }
}
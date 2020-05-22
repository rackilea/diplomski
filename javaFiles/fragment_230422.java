import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        final List<String> command = new ArrayList<>();

        command.add("nmap");
        command.add("-T5");
        command.add("-sP");
        command.add("172.19.0.0-255");

        executeCommand(command);
    }

    private static int executeCommand(final List<String> command) {
        try {
            final ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash").command(command);
            processBuilder.redirectErrorStream(true);

            System.out.println("executing: " + processBuilder.command().toString());

            final Process process = processBuilder.start();
            final InputStream inputStream = process.getInputStream();
            final InputStream errorStream = process.getErrorStream();

            readStream(inputStream);
            readStream(errorStream);

            return process.waitFor();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return -1;
    }

    private static void readStream(final InputStream iStream) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(iStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
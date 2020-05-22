package es.os.linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author adrian
 */
public class Konsole {

    static Process process;
    static BufferedReader reader;

    public static String executeCommand(String command) throws IOException, InterruptedException {
        String rez = "";
        process = Runtime.getRuntime().exec(command);
        process.waitFor();
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            rez += line + "#";
        }
        return rez;
    }
}
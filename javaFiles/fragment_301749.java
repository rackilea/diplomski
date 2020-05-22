import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Hex {
    public static void binaryToHex(InputStream is, OutputStream os) {
        Writer writer = new BufferedWriter(new OutputStreamWriter(os));

        try {
            int value;

            while ((value = is.read()) != -1) {
                writer.write(String.format("%02X", value));
            }

            writer.flush();
        } catch (IOException e) {
            System.err.println("An error occurred");
        }
    }

    public static void hexToBinary(InputStream is, OutputStream os) {
        Reader reader = new BufferedReader(new InputStreamReader(is));

        try {
            char buffer[] = new char[2];

            while (reader.read(buffer) != -1) {
                os.write((Character.digit(buffer[0], 16) << 4)
                        + Character.digit(buffer[1], 16));
            }
        } catch (IOException e) {
            System.err.println("An error occurred");
        }
    }
}
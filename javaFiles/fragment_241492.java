import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Runner {

    public static void pipeStream(InputStream input, OutputStream output) throws IOException {
        byte buffer[] = new byte[1024];
        int numRead = 0;

        do {
            numRead = input.read(buffer);
            output.write(buffer, 0, numRead);
        } while (input.available() > 0);

        output.flush();
    }

    public static void main(String[] argv) {
        File dir = new File("C:\\Users\\Leo\\workspace\\STackOverflow\\src\\");
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;

        OutputStream procIn = null;
        InputStream procOut = null;

        try {
            fileIn = new FileInputStream(new File(dir, "input.txt"));
            fileOut = new FileOutputStream(new File(dir, "output.txt"));

            Process process = Runtime.getRuntime().exec("C:\\jdk1.7.0_51\\bin\\java Hello", null, dir);
            procIn = process.getOutputStream();
            procOut = process.getInputStream();

            pipeStream(fileIn, procIn);
            pipeStream(procOut, fileOut);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
import java.io.*;

public class Example {
    public static final void main(String[] args) {
        System.out.println("Writing to test.txt");
        try (
            Writer w = new FileWriter("test.txt");
            BufferedWriter bw = new BufferedWriter(w);
        ) {
            bw.append("Testing 1 2 3");
            bw.append("\r\n");
            bw.append("More Testing");
            bw.append("\r\n");
        }
        catch (IOException ioe) {
            System.err.println("Error writing to file: " + ioe.getMessage());
        }
        System.out.println("Done");
    }
}
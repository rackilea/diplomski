import java.io.*;

public class NewChars {

    public static void main(String[] args) throws IOException {
        // UTF-16 (surrogate pairs) for the two characters mentioned:
        String theChars = "\ud87c\udf32\ud87e\udd74";

        // Write the characters to a (UTF-8 encoded) byte stream:
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
        Writer out = new OutputStreamWriter(baos, "UTF-8");

        out.write(theChars);
        out.close();

        // Read the characters back
        BufferedReader in = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream(baos.toByteArray()), "UTF-8"));
        String readBack = in.readLine();

        // Check the result (prints "Readback is good"):
        System.out.println(theChars.equals(readBack) ? "Readback is good"
                : "Readback is bad");
    }
}
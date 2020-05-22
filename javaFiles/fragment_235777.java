import java.io.*;
import java.util.zip.GZIPInputStream;

public class GZipFile {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new GZIPInputStream(new FileInputStream(
                        "comp_dump")), "UTF-8"));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\r\n");
        }
        System.out.println(sb.toString());
    }
}
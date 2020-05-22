import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatalogReader {

    public static void processFile (String input, String output) throws FileNotFoundException {

        try {

            // File input
            FileInputStream fstream = new FileInputStream(input);   
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader (new InputStreamReader(in));

            //File output
            File out = new File(output);
            FileOutputStream fos = new FileOutputStream(out);
            BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(fos));

            String line;
            String product = "";

            Pattern pat = Pattern.compile("</catalogue>");
            Matcher mat;

            while ((line = br.readLine()) != null) {

                mat = pat.matcher(line);

                while (!mat.find()) {

                    product.concat(line);

                }

                bw.write(product);
                bw.newLine()
                product = "";

            }

            br.close();
            bw.close();
        }

        catch (IOException e) { System.err.println("Error: " + e.getMessage());}
    }

}
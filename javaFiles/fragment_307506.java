import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.File;

public class pythonfromjava{
    public static void main(String argv[]) {
        try{
            // for tilda expansion
            //if (filepath.startsWith("~" + File.separator)) {
                //filepath = System.getProperty("user.home") + filepath.substring(1);
            //}

            //ProcessBuilder builder = new ProcessBuilder("python", "-c", "import sys; import nltk; print \"whatever\"");
            ProcessBuilder builder = new ProcessBuilder("python", "testing.py", "four scores and seven years ago");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            InputStream stdout = p.getInputStream();
            BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));

            String line;
            while ((line = reader.readLine ()) != null) {
                System.out.println ("Stdout: " + line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
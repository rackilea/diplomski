import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class CmdExec {

public static void main(String args[]) {
    try {
        // enter code here

        Process p = Runtime.getRuntime().exec(
            Paths.get(System.getenv("windir"), "system32", "tree.com /A").toString()
        );

        // enter code here

        try(BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        }

    } catch (Exception err) {
        err.printStackTrace();
    }
  }
}
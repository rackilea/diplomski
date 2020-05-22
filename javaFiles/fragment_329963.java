import java.io.BufferedReader;
import java.io.InputStreamReader;

/** @see https://stackoverflow.com/a/15121864/230513 */
public class PBTest {

    private static final String baseDir = "/opt/jfreechart/";
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp",
            baseDir + "lib/*:" + baseDir + "jfreechart-1.0.14-demo.jar",
            "demo.SuperDemo");
        pb.redirectErrorStream(true);
        try {
            Process p = pb.start();
            String s;
            // read from the process's combined stdout & stderr
            BufferedReader stdout = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = stdout.readLine()) != null) {
                System.out.println(s);
            }
            System.out.println("Exit value: " + p.waitFor());
            p.getInputStream().close();
            p.getOutputStream().close();
            p.getErrorStream().close();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
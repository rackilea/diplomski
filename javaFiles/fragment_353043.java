import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            ProcessBuilder pb = new ProcessBuilder("/home/dac/proj/javatest2016/src/main/java/myshellScript.sh", "myArg1", "myArg2");
            pb.directory(new File("/home/dac/proj/javatest2016/src/main/java"));
            Process p = pb.start();
            StringBuffer output = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }
            System.out.println("### " + output);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
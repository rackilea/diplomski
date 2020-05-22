import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Script {

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                String cmdScript = "/home/abd.sh";

                StringBuilder output2 = new StringBuilder();

                try {
                    Process procScript =  Runtime.getRuntime().exec(cmdScript);
                    procScript.waitFor();
                    BufferedReader reader =
                        new BufferedReader(new InputStreamReader(procScript.getInputStream()));
                    // System.out.println(reader);
                    String line = "";
                    while ((line = reader.readLine())!= null) {

                        output2.append(line + "\n");
                        System.out.println(output2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }

}
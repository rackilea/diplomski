import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class TestPB {

    public static void shellExecuteBuilder(String[] command) {

        ProcessBuilder prb;

        try {
            prb = new ProcessBuilder(command);
            prb.redirectErrorStream(true);
            Process pro = prb.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            String line;
            while( (line = r.readLine()) != null) {
                System.out.println(line);
            }
            pro.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static final void main(String[] args) {
        TestPB tpb = new TestPB();
        String[] command = new String[] {"/bin/sh", "-c", "cd /path/to/my/script/; ./start.sh"};
        TestPB.shellExecuteBuilder(command);
    }
}
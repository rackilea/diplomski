import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args){
        Test t = new Test();

        t.start();
    }

    private void start(){
        String command = //Command to invoke the program

        ProcessBuilder pb = new ProcessBuilder(command);

        try{
            Process p = pb.start();

            InputStream stdout = p.getInputStream();
            InputStream stderr = p.getErrorStream();

            StreamListener stdoutReader = new StreamListener(stdout);
            StreamListener stderrReader = new StreamListener(stderr);

            Thread t_stdoutReader = new Thread(stdoutReader);
            Thread t_stderrReader = new Thread(stderrReader);

            t_stdoutReader.start();
            t_stderrReader.start();
        }catch(IOException n){
            System.err.println("I/O Exception: " + n.getLocalizedMessage());
        }
    }

    private class StreamListener implements Runnable{
        private BufferedReader Reader;
        private boolean Run;

        public StreamListener(InputStream s){
            Reader = new BufferedReader(new InputStreamReader(s));
            Run = true;
        }

        public void run(){
            String line;

            try{
                while(Run && (line = Reader.readLine()) != null){
                    //At this point, a line of the output from the external process has been grabbed. Process it however you want.
                    System.out.println("External Process: " + line);
                }
            }catch(IOException n){
                System.err.println("StreamListener I/O Exception!");
            }
        }
    }
}
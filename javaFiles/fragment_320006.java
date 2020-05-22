import java.lang.*;
import java.io.*;

public class StreamGobbler implements Runnable {
    String name;
    InputStream is;
    Thread thread;
    String output="";

    public StreamGobbler (String name, InputStream is) {
    this.name = name;
    this.is = is;
    }

    public void start () {
    thread = new Thread (this);
    thread.start ();
    }

    public void run () {
    try {
    InputStreamReader isr = new InputStreamReader (is);
    BufferedReader br = new BufferedReader (isr);

       while (true) {
          String s = br.readLine ();
          if (s == null) break;
          output += s;
       }
       is.close ();
       } catch (Exception ex) {
          System.out.println ("Problem reading stream " + name + "... :" + ex);
         ex.printStackTrace ();
       }
    }
}

    public class ProgA {
    public static void main(String[] args) throws Exception {
    Runtime rt = Runtime.getRuntime();
    Process p = rt.exec("execute command prompt");
    StreamGobbler s1 = new StreamGobbler ("stdin", p.getInputStream ());
    StreamGobbler s2 = new StreamGobbler ("stderr", p.getErrorStream ());
    s1.start ();
    s2.start ();
    p.waitFor();
    System.out.println(s2.output + s1.output);
    }
    }
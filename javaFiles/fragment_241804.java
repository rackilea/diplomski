import java.io.*;

public class PythonProcessRedirect {

  public static void main(String [] arg) throws Exception {

    ProcessBuilder pb =
      new ProcessBuilder("python", "script_raw.py");
    pb.redirectErrorStream(true);
    pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
    Process p = pb.start();

    BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( p.getOutputStream() ));
    String input = "2\n";
    writer.write(input);
    writer.flush();

    p.waitFor();
  }
}
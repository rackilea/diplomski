import java.io.*;

public class PythonProcessStreamGobblerIO {

  public static void main(String [] arg) throws Exception {

    final Process p = Runtime.getRuntime().exec("python ./script_os.py" );

    new Thread() {
      public void run() {
        try {
          BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( p.getOutputStream() ));
          String input = "2\n";
          writer.write(input);
          writer.flush();
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }
    }.start();

    new Thread() {
      public void run() {
        try {
          Reader reader = new InputStreamReader(p.getInputStream());  
          int data = -1;
          while((data =reader.read())!= -1){
            char c = (char) data;
            System.out.print(c);
          }
          reader.close();
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }
    }.start();

    p.waitFor();
  }
}
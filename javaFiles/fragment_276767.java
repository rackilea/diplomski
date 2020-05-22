import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;

import java.util.LinkedList;

public class Example {
  protected static final int SKIP_N = 42; 

  public static void main (String[] args)
    throws Exception
  {
    String line;

    LinkedList<String> lli = new LinkedList<String> (); 

    FileInputStream   fis = new FileInputStream   ("/tmp/sample_file");
    DataInputStream   dis = new DataInputStream   (fis);
    InputStreamReader isr = new InputStreamReader (dis);
    BufferedReader    bre = new BufferedReader    (isr);

    while ((line = bre.readLine ()) != null) {
      lli.addLast (line);

      if (lli.size () > SKIP_N) {
        System.out.println (lli.removeFirst ());
      }   
    }   

    dis.close (); 
  }
}
import java.io.*;

public class T {
  public static void main( String args[] ) throws Exception {
    BufferedReader br = new BufferedReader(
      new InputStreamReader(
      new FileInputStream( "tasklist.txt" ) ) );

    String line;

    while( (line = br.readLine()) != null ) {
      if( line.startsWith( "skypePM.exe" ) ) {
        line = line.substring( "skypePM.exe".length() );
        int taskId = Integer.parseInt( (line.trim().split( " " ))[0] );

        System.out.println( "Task Id: " + taskId );
      }
    }

    br.close();
  }
}
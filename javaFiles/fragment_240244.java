import java.io.*;
class Rt { 
  public static void main(String args[]) throws Exception {
          Runtime RT = Runtime.getRuntime();
          String  command =  "javap java.lang.String" ; 
          File file = new File("write.txt");
          Writer output = new BufferedWriter(new FileWriter(file));
          BufferedReader br = new BufferedReader(new InputStreamReader(RT.exec(command).getInputStream()));
          String temp = br.readLine();
          while( temp != null ) { //!temp.equals(null)) {
              output.write(temp);
              temp = br.readLine();
          }
          output.close();
          //RT.exec("exit");
  }
}
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CSVReadLoginPass {

 public static  Map<String,String> map1 = null;
 public static  Map<String,String> map2 = null;
  public static void main(String[] args) {

      try
      {
          readFileandPopulate();
          for (Map.Entry<String, String> entry : map1.entrySet()) {
                System.out.println("Key : " + entry.getKey() + " Value : "
                    + entry.getValue()+" address :"+map2.get(entry.getKey()));
                //insert into DB
            }
            }catch (Exception e){//Catch exception if any
                e.printStackTrace();
          System.err.println("Error: " + e.getMessage());
          }

  }
  public static void readFileandPopulate() throws Exception
  {


      FileInputStream fstream = new FileInputStream("E:\\Eclipse-Leo\\StackOverflow\\src\\resources\\textfile1.csv");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String strLine;
      map1 = new HashMap<String,String>();
          while ((strLine = br.readLine()) != null)   {
              System.out.println(strLine);
          String temp[] = strLine.split(",");
          map1.put(temp[0], temp[1]);

      }
     in.close();
     System.out.println("done 1");


     FileInputStream fstream2 = new FileInputStream("E:\\Eclipse-Leo\\StackOverflow\\src\\resources\\textfile2.csv");
      DataInputStream in2= new DataInputStream(fstream2);
      BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
      String strLine2;
          map2 = new HashMap<String,String>();
          while ((strLine2 = br2.readLine()) != null)   {
              System.out.println(strLine2);
          String temp[] = strLine2.split(",");
          map2.put(temp[0], temp[1]);

      }
     in2.close();
  }
}
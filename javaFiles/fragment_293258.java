import java.io.*;
 public class Main
  {
    public static void main(String []args)
     {
        try {
             int i;
              String line,pn,pt;
              pn="";
              Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");


              BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((line = input.readLine()) != null)
            {
               if(line.contains("Console"))
               {
                   if(line.length()>30){
                   pn=line.substring(0,30); System.out.println(pn);}
            }
              System.out.println();
             }
        input.close();
       }
     catch (Exception err) 
     {
       err.printStackTrace();
     }
}}
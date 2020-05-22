import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Compile {
public static void main(String args[]){

    String ret = compile();
    System.out.println(ret);

}
    public static String compile()
    {
        String log="";
        String myDirectory = "C:\\";
         try {
             String s= null;
           //change this string to your compilers location,Assume C file is in c:\\Hello.c
             Process p = Runtime.getRuntime().exec("cmd /C gcc Hello.c", null, new java.io.File(myDirectory));

         BufferedReader stdError = new BufferedReader(new 
              InputStreamReader(p.getErrorStream()));
         boolean error=false;

         log+="";
         while ((s = stdError.readLine()) != null) {
             log+=s;
             error=true;
             log+="\n";

         }
         if(error==false) log+="Compilation Successful !!!";

     } catch (IOException e) {
         e.printStackTrace();
     }
         return log;
    }


  public int runProgram() 
    {
        int ret = -1;
       try
         {            
             Runtime rt = Runtime.getRuntime();
             Process proc = rt.exec("cmd.exe /c start a.exe");
             proc.waitFor();
             ret = proc.exitValue();
         } catch (Throwable t)
           {
             t.printStackTrace();
             return ret;
           }
       return ret;                      
    }}
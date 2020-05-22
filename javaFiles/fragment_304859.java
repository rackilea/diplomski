public static void printStream(InputStream is, String type){
try
   {
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String line=null;
      while ( (line = br.readLine()) != null)
            System.out.println(type + ">" + line);    
   } catch (IOException ioe){
           ioe.printStackTrace();  
   }
}

public static void main(String args[])
{
    String cmd = "command to execute";
    Process proc = Runtime.getRuntime().exec("sshpass -p sbsiz scp '/home/surendra/Desktop/remote_backup.txt' root@192.168.59.115:/home/");
    printStream(proc.getInputStream(), "OUTPUT");
    printStream(proc.getErrorStream(), "ERROR");
}
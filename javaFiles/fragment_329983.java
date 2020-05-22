import java.io.IOException;
import java.io.InputStream;


public class MYProcess
{
   int startProcess()
   {
      String cmd = "/opt/test/bin/mystart.sh"

      // create a process for the shell
      ProcessBuilder pb = new ProcessBuilder("bash", "-c", cmd);
   // use this to capture messages sent to stderr
      pb.redirectErrorStream(true);                                      
      Process shell = null;
      int shellExitStatus =-1;     
      try
      {
         shell = pb.start();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      InputStream shellIn = shell.getInputStream();
      try
      {
         shellExitStatus = shell.waitFor();
         //logger.info("call exit status:" + shellExitStatus);
         //logger.info("If exit status is not zero then call is not successful. Check log file.");        
      }
      catch (InterruptedException e)
      {
         //logger.error("error while call" + e);
         e.printStackTrace();
      } // wait for the shell to finish and get the return code
      return shellExitStatus;
   }
}
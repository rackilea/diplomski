import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Properties;

public class cmdExec
{
  public static void main(String[] arg)
  {
    try
    {
      JSch jsch = new JSch();

      String user = "<username>";
      String host = "<host>";
      String paswrd = "<password>";

      Session session = jsch.getSession(user, host, 22);

      Properties config = new Properties();
      config.put("StrictHostKeyChecking", "no");

      session.setPassword(paswrd);

      session.setConfig(config);
      session.connect();

      // build an array of commands to run
      String[] cmds = {"user | wc -l", "ps -ef | wc -l"};

      for(int cnt = 0; cnt < cmds.length; cnt++)
      {
        String command = cmds[cnt];

        Channel channel = session.openChannel("exec");
        ((ChannelExec)channel).setCommand(command);

        channel.setInputStream(null);

        ((ChannelExec)channel).setErrStream(System.err);

        InputStream in = channel.getInputStream();

        channel.connect();

        byte[] tmp = new byte[1024];

        while (true){

            while (in.available()>0){
              int i = in.read(tmp, 0, 1024);
              if (i < 0)
              {
                break;
              }
              // grab the return, hopefully a number
              String strRet = new String(tmp, 0, i);
              // trim whitespace and convert to int
              int ret = Integer.parseInt(strRet.trim());

              if ( ret != 1 )
              {
                System.out.println("Do something else, the return wasn't one.");
              }
              else
              {
                System.out.println("Return was 1. Continuing on...");
              }
            }
            if(channel.isClosed()){
              if(in.available()>0) continue;
              //System.out.println("exit-status: "+channel.getExitStatus());
              break;
            }
            try
            {
              Thread.sleep(1000);
            }
            catch (Exception ee)
            {
              // Do something with the exception
            }  
        }
        channel.disconnect();

      }
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.oozie.client.AuthOozieClient;
import org.apache.oozie.client.WorkflowJob.Status;

public class Wrapper
{
    public static AuthOozieClient wc = null;
    public static String OOZIE_SERVER_URL="http://localhost:11000/oozie";

   public Wrapper ( String oozieUrlStr ) throws MalformedURLException
    {
        URL oozieUrl = new URL(oozieUrlStr);
        // get a OozieClient for local Oozie
        wc = new AuthOozieClient(oozieUrl.toString());
    }

    public static void main ( String [] args )
    {
        String lineCommon;
        String jobId = args[0]; // The first argument is the oozie jobid

        try
        {
            Wrapper client = new Wrapper(OOZIE_SERVER_URL);
            Properties conf = wc.createConfiguration();

            if(wc != null)
            {
                // get status of jobid from CLA
                try
                {
                    while (wc.getJobInfo(jobId).getStatus() == Status.RUNNING)
                    {
                        logger.info("Workflow job running ...");
                        logger.info("Workflow job ID:["+jobId+"]");
                    }
                    if(wc.getJobInfo(jobId).getStatus() == Status.SUCCEEDED)
                    {
                        // print the final status of the workflow job
                        logger.info("Workflow job completed ...");
                        logger.info(wc.getJobInfo(jobId));
                    }
                    else
                    {
                    // print the final status of the workflow job
                    logger.info("Workflow job Failed ...");
                    logger.info(wc.getJobInfo(jobId));
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                System.exit(9999);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
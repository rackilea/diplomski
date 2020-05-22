import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobStatus;
import org.apache.hadoop.conf.Configuration;
import java.net.InetSocketAddress;
import org.apache.hadoop.mapred.Counters;
import org.apache.hadoop.mapred.ClusterStatus;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapred.*;
public class jobclienttest{
        public static void main(String args[]){
                String jobTrackerHost = "192.168.151.14";
                int jobTrackerPort = 54311;
                try{
                        JobClient jobClient = new JobClient(new InetSocketAddress(jobTrackerHost, jobTrackerPort), new Configuration());
                        JobStatus[] activeJobs = jobClient.jobsToComplete();

                        for(JobStatus js: activeJobs){
                                System.out.println(js.getJobID());
                                RunningJob runningjob = jobClient.getJob(js.getJobID());
                                Counters counters = runningjob.getCounters();
                                Counter counter = counters.findCounter("org.apache.hadoop.mapred.Task$Counter","REDUCE_INPUT_GROUPS");
                                System.out.println(counter.getValue());
                        }
                }catch(Exception ex){
                        ex.printStackTrace();
                }
        }
}
package stackoverflow.answer;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class sample {
    public static void main(String[] args) throws Exception {
        final Logger log = Logger.getLogger(sample.class.getCanonicalName());
        JobData jd = new JobData();

        Scanner input = new Scanner(System.in);
        try {
            System.out.print("What is your user name? ");
            jd.setUsername(input.next());
            System.out.print("What is your password? ");
            jd.setPassword(input.next());
        } catch (Exception e) {
            log.log(Level.SEVERE, "The system encountered an exception while attempting to login");
        } finally {
              input.close();
        }

        jd.setJob("TestREST");
        jd.setServer("http://YOUR-SERVER");
        jd.setPort("YOUR-PORT");
        // set the parameters
        List<NameValuePair> parameters = jd.getParameters();
        parameters.add(new BasicNameValuePair("SONAR-TARGET", "true"));
        parameters.add(new BasicNameValuePair("RELEASE", "1311.1.1"));
        parameters.add(new BasicNameValuePair("REVISION", "HEAD"));
        // run the job
        JenkinsPoster jp = new JenkinsPoster(jd);
        log.info("executing postJenkinsJob");
        jp.postJenkinsJob();
        log.info("executed postJenkinsJob");
    }   
}
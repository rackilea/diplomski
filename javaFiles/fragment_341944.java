package mypackage;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TriggerScheduledJob {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("addB")
    private Job addBJob;

    @Autowired
    @Qualifier("addC")
    private Job addCJob;

    public void triggerAddB() {
        JobParameters param = new JobParametersBuilder().addString("id", UUID.randomUUID().toString()).toJobParameters();
        try {
            JobExecution execution = jobLauncher.run(addBJob, param);
            System.out.println("Job executed with exit status = " + execution.getStatus());
        } catch (Exception e) {
            System.out.println("Failed to execute job. " + e.getMessage());
        }
    }

    public void triggerAddC() {
        JobParameters param = new JobParametersBuilder().addString("id", UUID.randomUUID().toString()).toJobParameters();
        try {
            JobExecution execution = jobLauncher.run(addCJob, param);
            System.out.println("Job addC executed with exit status = " + execution.getStatus());
        } catch (Exception e) {
            System.out.println("Failed to execute job. " + e.getMessage());
        }
    }
}
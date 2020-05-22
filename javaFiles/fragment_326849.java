import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class FlowJobSample {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Step personLoadingStep() {
        return steps.get("personLoadingStep")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("personLoadingStep");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step addressLoadingStep() {
        return steps.get("addressLoadingStep")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("addressLoadingStep");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step crossValidationStep() {
        return steps.get("crossValidationStep")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("crossValidationStep");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step reportingStep() {
        return steps.get("reportingStep")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("reportingStep");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Job job() {
        return jobs.get("job")
                .start(personLoadingStep()).on("INVALID").to(reportingStep())
                    .from(personLoadingStep()).on("*").to(addressLoadingStep())
                    .from(addressLoadingStep()).on("INVALID").to(reportingStep())
                    .from(addressLoadingStep()).on("*").to(crossValidationStep())
                    .from(crossValidationStep()).on("INVALID").to(reportingStep())
                    .from(crossValidationStep()).on("*").end()
                    .from(reportingStep()).on("*").fail()
                    .build()
                .build();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(FlowJobSample.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());
    }

}
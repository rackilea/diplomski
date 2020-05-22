import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ByteArrayResource;

@Configuration
@EnableBatchProcessing
public class MyJob {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    @StepScope
    public FlatFileItemReader<String> itemReader() {
        FlatFileItemReader<String> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(1);   //skip header line
        reader.setResource(new ByteArrayResource("header\nitem1\nitem2\n2".getBytes()));
        reader.setLineMapper(new PassThroughLineMapper());
        return reader;
    }

    @Bean
    public ItemWriter<String> itemWriter() {
        return items -> {
            for (String item : items) {
                System.out.println("item = " + item);
            }
        };
    }

    @Bean
    public Step step1() {
        MyListener myListener = new MyListener();
        return steps.get("step1")
                .<String, String>chunk(5)
                .reader(itemReader())
                .writer(itemWriter())
                .listener((ItemReadListener<String>) myListener)
                .listener((StepExecutionListener) myListener)
                .build();
    }

    @Bean
    public Step step2() {
        return steps.get("step2")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Total count is ok as validated by step1");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Job job() {
        return jobs.get("job")
                .start(step1())
                .next(step2())
                .build();
    }

    static class MyListener extends StepExecutionListenerSupport implements ItemReadListener<String> {

        private String lastItem;

        @Override
        public void beforeRead() {
        }

        @Override
        public void afterRead(String item) {
            this.lastItem = item;
        }

        @Override
        public void onReadError(Exception ex) {

        }

        @Override
        public ExitStatus afterStep(StepExecution stepExecution) {
            int readCount = stepExecution.getReadCount();
            int totalCountInFooter = Integer.valueOf(this.lastItem); // TODO sanity checks (number format, etc)
            System.out.println("readCount = " + (readCount - 1)); // substract footer from the read count
            System.out.println("totalCountInFooter = " + totalCountInFooter);
            // TODO do validation on readCount vs totalCountInFooter
            return ExitStatus.COMPLETED; // return appropriate exit status according to validation result
        }
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyJob.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());
    }

}
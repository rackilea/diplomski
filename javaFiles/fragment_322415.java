import org.jberet.job.model.Job;
import org.jberet.operations.JobOperatorImpl;
import org.jberet.spi.JobOperatorContext;

JobOperatorImpl jobOperator = (JobOperatorImpl) JobOperatorContext.getJobOperatorContext().getJobOperator();

Job job = new JobBuilder(jobName)
                .step(new StepBuilder(stepName)
                        .reader(...)
                        .writer(...)
                        .build())
                .build();
Properties params = null;
long jobExecutionId = jobOperator.start(job, params);
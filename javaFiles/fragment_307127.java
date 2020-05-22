@Component
public class Clf010Processor implements ItemProcessor<Clf010Item, Clf010Item> {

    BatchProgram batch = new BatchProgram();

    @AfterStep
    public void afterStep(StepExecution stepExecution) {
        ExecutionContext je = stepExecution.getJobExecution().getExecutionContext();
        // Pass the counts up to the execution context.
        je.putLong("writeCount", stepExecution.getWriteCount());
        je.putLong("clfCount", stepExecution.getWriteCount());
        je.putLong("readCount", stepExecution.getReadCount());
        // Log the program results
        batch.print("");
        batch.print("**********************************************************");
        batch.print("INPUT RECORDS READ =  " + stepExecution.getReadCount());
        batch.print("**********************************************************");
        batch.print("");
        batch.print("**********************************************************");
        batch.print("OUTPUT RECORDS WRITTEN =  " + stepExecution.getWriteCount());
        batch.print("**********************************************************");
        batch.print("");
    }

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {}

    @Override
    public Clf010Item process(Clf010Item item) throws Exception {
        return item;
    }

}
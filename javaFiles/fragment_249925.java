public class LoopingListener extends StepExecutionListenerSupport {

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if(shouldLoop) {
            return new ExitStatus("BACK");
        } else {
            return stepExecution.getExitStatus();
        }
    }
}
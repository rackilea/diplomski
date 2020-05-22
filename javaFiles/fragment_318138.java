@ServiceActivator
public StepExecution handle(StepExecutionRequest request) {

    Long jobExecutionId = request.getJobExecutionId();
    Long stepExecutionId = request.getStepExecutionId();
    StepExecution stepExecution = jobExplorer.getStepExecution(jobExecutionId, stepExecutionId);
    if (stepExecution == null) {
        throw new NoSuchStepException("No StepExecution could be located for this request: " + request);
    }

    String stepName = request.getStepName();
    Step step = stepLocator.getStep(stepName);
    if (step == null) {
        throw new NoSuchStepException(String.format("No Step with name [%s] could be located.", stepName));
    }

    try {
        step.execute(stepExecution);
    }
    catch (JobInterruptedException e) {
        stepExecution.setStatus(BatchStatus.STOPPED);
        // The receiver should update the stepExecution in repository
    }
    catch (Throwable e) {
        stepExecution.addFailureException(e);
        stepExecution.setStatus(BatchStatus.FAILED);
        // The receiver should update the stepExecution in repository
    }

    return stepExecution;

}
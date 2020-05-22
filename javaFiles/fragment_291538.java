...
private JobExecution jobE;
...

public Long getProgress() {

    double jobComplete = (Double) jobE.
                            getExecutionContext().
                            get("jobComplete");
    double reads = 0;       
    for (StepExecution step : jobE.getStepExecutions()) {
        reads = reads + step.getReadCount();
    }
    return Math.round(reads / jobComplete * 100);
}
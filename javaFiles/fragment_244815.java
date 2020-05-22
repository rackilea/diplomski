public class TestListener implements StepExecutionListener, ItemReadListener<String> {
    private StepExecution stepExecution;
    private static final String CURRENT_ID = "currentId";

    @Override
    public void beforeStep(final StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public ExitStatus afterStep(final StepExecution stepExecution) {
        return null;
    }

    @Override
    public void beforeRead() {
    }

    @Override
    public void afterRead(final String item) {
        String currentId = null;
        if (stepExecution.getExecutionContext().containsKey(CURRENT_ID)) {
            currentId = stepExecution.getExecutionContext().getString(CURRENT_ID);
        } else {
            String fileName = stepExecution.getExecutionContext().getString("fileName");
            // ... create ID from FileName
            currentId = fileName + "foo";
            stepExecution.getExecutionContext().put(CURRENT_ID, currentId);
        }
    }

    @Override
    public void onReadError(final Exception ex) {
    }
}
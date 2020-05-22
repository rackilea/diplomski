public class MyPartitionAnalyzer extends AbstractPartitionAnalyzer {

    @Inject
    private StepContext stepCtx;

    @Override
    public void analyzeStatus(BatchStatus batchStatus, String exitStatus) throws Exception {

        // Overrides default exit status if non-COMPLETED partition seen
        if (!exitStatus.equals(BatchStatus.COMPLETED)) {
            stepCtx.setExitStatus(exitStatus);
        }
    }
}
public class MyProcessTask extends Task<SomeData> {

    @Override
    protected SomeData call() throws Exception {
        MyProcess process = new MyProcess();
        process.progressProperty().addListener((obs, oldProgress, newProgress) ->
            updateProgress(newProgress, 1.0));
        return process.call();
    }
}
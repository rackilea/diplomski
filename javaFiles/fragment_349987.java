public class MyProcessTask extends Task<SomeData> {

    @Override
    protected SomeData call() throws Exception {
        MyProcess process = new MyProcess();
        process.setProgressUpdate(p -> updateProgress(p, 1.0));
        return process.call();
    }
}
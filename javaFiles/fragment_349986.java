public class MyProcess implements Callable<SomeData> {

    private DoubleConsumer progressUpdate = d -> {} ; // no-op
    private double progress ;

    public void setProgressUpdate(DoubleConsumer progressUpdate) {
        this.progressUpdate = progressUpdate ;
    }

    public final double getProgress() {
        return progress;
    }

    private void setProgress(double progress) {
        this.progress = progress ;
        progressUpdate.accept(progress);
    }

    @Override
    public SomeData call() {
        final int numSteps = ... ;
        SomeData data = new SomeData();
        for (int i = 0 ; i < numSteps ; i++) {
            setProgress(1.0*i/numSteps) ;
            data.update(i);
        }
        return data ;
    }
}
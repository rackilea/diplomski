public class MyProcess implements Callable<SomeData> {

    private final ReadOnlyDoubleWrapper progress = new ReadOnlyDoubleWrapper();

    public ReadOnlyDoubleProperty progressProperty() {
        return progress.getReadOnlyProperty() ;
    }

    public final double getProgress() {
        return progressProperty().get();
    }

    @Override
    public SomeData call() {
        final int numSteps = ... ;
        SomeData data = new SomeData();
        for (int i = 0 ; i < numSteps ; i++) {
            progress.set(1.0*i/numSteps);
            data.update(i);
        }
        return data ;
    }
}
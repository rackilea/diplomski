public class SubGame {

    private final BooleanProperty finished = new SimpleBooleanProperty();

    public BooleanProperty finishedProperty() {
        return finished ;
    }

    public final boolean isFinished() {
        return finishedProperty().get();
    }

    public final void setFinished(boolean finished) {
        finishedProperty().set(finished) ;
    }

    // ...
}
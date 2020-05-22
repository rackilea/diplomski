public class ButtonModel {
    private final BooleanProperty paused = new SimpleBooleanProperty();

    public final BooleanProperty pausedProperty() {
        return paused ;
    }

    public final boolean isPaused() {
        return pausedProperty().get();
    }

    public final void setPaused(boolean paused) {
        pausedProperty().set(paused);
    }

    public void togglePaused() {
        setPaused(! isPaused());
    }

    //... Other Getters and Setters...
}
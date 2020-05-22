public class Model {

    private SimpleBooleanProperty active = new SimpleBooleanProperty(true);

    public boolean getActive() {
        return active.get();
    }

    public SimpleBooleanProperty activeProperty() {
        return active;
    }

    public void setActive(boolean active) {
        this.active.set(active);
    }
}
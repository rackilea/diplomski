public class Test {
    private final IntegerProperty count = new SimpleIntegerProperty(this, "count", 0);
    private final StringProperty title = new SimpleStringProperty(this, "title", "");

    public final int getCount() {
        return count.get();
    }
    public final void setCount(int count) {
        this.count.set(count);
    }

    public IntegerProperty countProperty() {
        return count ;
    }

    public final String getTitle() {
        return title.get();
    }
    public final void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title ;
    }
}
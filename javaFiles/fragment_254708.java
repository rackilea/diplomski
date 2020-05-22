public class EntryItem implements Item {

    public final String title;
    public final String value;

    public EntryItem(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean isSection() {
        return false;
    }
}
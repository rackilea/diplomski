public class TableType {
    String text;
    boolean clicked = false;

    public TableType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
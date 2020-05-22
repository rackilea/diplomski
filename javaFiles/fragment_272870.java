public class cell extends ListCell<String> {
    private final Rectangle rect;

    cell() {
        super();
        this.rect = new Rectangle(20,20);
        setGraphic(this.rect);
    }

    @Override
    protected void updateItem(String s, boolean empty) {
        super.updateItem(s, empty);
        if(empty)
            rect.setVisible(false);
        else {
            rect.setFill(Color.web(getItem()));
            rect.setVisible(true);
        }
    }
}
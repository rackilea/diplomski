public class YourFormatCell extends ListCell<String> {
    @Override 
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setText(item);
        setTextFill(isSevere(item)?Color.RED:Color.GREEN);
    }
}
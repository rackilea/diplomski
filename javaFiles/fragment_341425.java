public class LocalDateTimeTableCell<S> extends TableCell<S, LocalDateTime> {
    private final DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private final DateTimeFormatter myDateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
    private final boolean showTime;

    public LocalDateTimeTableCell(boolean showTime){
        this.showTime = showTime;
    }
    @Override
    protected void updateItem(LocalDateTime item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setText(null);
            setStyle("");
        } else {
            // Format date.
            if(showTime) {
                setText(myDateTimeFormatter.format(item));
            }else {
                setText(myDateFormatter.format(item));
            }
        }
    }
}
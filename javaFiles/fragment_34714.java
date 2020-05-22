TableColumn<MyTableType, LocalDate> dateColumn ;
// ...
dateColumn.setCellValueFactory(...);
DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE;
dateColumn.setCellFactory(col -> new TableCell<MyTableType, LocalDate>() {
    @Override
    protected void updateItem(LocalDate date, boolean empty) {
        super.updateItem(date, empty);
        if (empty) {
            setText(null);
        } else {
            setText(dateFormat.format(date));
        }
    }
});
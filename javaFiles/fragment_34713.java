DateFormat dateFormat = DateFormat.getDateInstance();
dateColumn.setCellFactory(col -> new TableCell<MyTableType, Calendar>() {
    @Override
    protected void updateItem(Calendar date, boolean empty) {
        super.updateItem(date, empty);
        if (empty) {
            setText(null);
        } else {
            setText(dateFormat.format(date.getTime()));
        }
    }
});
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
column_AddDate.setCellFactory(tc -> new TableCell<MyTableItem, LocalDateTime>() {
    @Override
    protected void updateItem(LocalDateTime item, boolean empty) {
        super.updateItem(item, empty);
        setText(empty ? null : formatter.format(item));
    }
});
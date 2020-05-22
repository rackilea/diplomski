lvPqAttributes.setCellFactory(lv -> new ListCell<RowlvPqAttributes>() {
    @Override
    public void updateItem(RowlvPqAttributes row, boolean empty) {
        super.updateItem(row, empty) ;
        setText(empty ? null : row.getText());
    }
}
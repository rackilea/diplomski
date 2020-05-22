private static <S> TableColumn<S, String> createColumn(String title, Function<S, Property<String>> property) {

    TableColumn<S, String> col = new TableColumn<>(title);

    col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));

    col.setOnEditCommit(edit -> {
        S rowValue = edit.getRowValue();
        property.apply(rowValue).setValue(edit.getNewValue());
    });

    col.setCellFactory(TextFieldTableCell.forTableColumn());

    return col;
}
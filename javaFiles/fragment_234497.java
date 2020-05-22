//Table columns
TableColumn<myTextRow, Number> clmID = new TableColumn<>("ID");
clmID.setMinWidth(160);
clmID.setCellValueFactory(cdf -> {
    myTextRow item = cdf.getValue();
    return item == addPlaceHolder ? Bindings.createObjectBinding(() -> null) : item.IDProperty();
});
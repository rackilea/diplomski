TableView<MyDataType> table = new TableView<>();

TableColumn<MyDataType, Integer> intColumn = new TableColumn<>("Int Column");
intColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

TableColumn<MyDataType, Double> doubleColumn = new TableColumn<>("Double Column");
doubleColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
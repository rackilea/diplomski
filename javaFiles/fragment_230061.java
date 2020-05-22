private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");

...    

TableColumn<Foo, String> ldtCol = new TableColumn<Foo, String>("LDT");
ldtCol.setCellValueFactory(foo -> new SimpleStringProperty(foo.getValue().getLdt().format(formatter)));
TableColumn basketColumn = new TableColumn("Basket?"); // note the use of the raw type here
basketColumn.setPrefWidth(200);

// note the hidden cast inserted here by the compiler based on the type parameter in the declaration
// this is the cause of the ClassCastException
basketColumn.setCellValueFactory(data -> new SimpleBooleanProperty(((Motorbike) data.getValue()).hasBasket()));
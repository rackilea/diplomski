TableColumn<Vehicle, Boolean> basketColumn = new TableColumn<>("Basket?");
basketColumn.setPrefWidth(200);
basketColumn.setCellValueFactory(data -> {
    Vehicle item = data.getValue();
    if (item instanceof Motorbike) {
        return new SimpleBooleanProperty(((Motorbike) item).hasBasket());
    } else {
        return null; // put something else here, if you don't want empty cells for non Motorbikes
    }
});
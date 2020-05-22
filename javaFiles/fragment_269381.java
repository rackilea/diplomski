startHour.setCellFactory((final ListView<String> param) -> {
    ListCell<String> cell = new ListCell<String>() {
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(item); // works in empty case as item will be null, as desired
        }
    };

    cell.disableProperty().bind(Bindings.createBooleanBinding(
        () -> {
            if (cell.getItem() == null) return false ;
            LocalDateTime selected = createDateTime(startDate.getValue(), cell.getItem(),
                        startMinute.getValue(), startMeridian.getValue());
            return selected.isBefore(LocalDateTime.now());
        }, 
        cell.itemProperty(), 
        startMinute.valueProperty(), 
        startMeridian.valueProperty(), 
        startDate.valueProperty()
    ));

    return cell ;
});
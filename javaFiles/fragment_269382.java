cell.disableProperty().bind(Bindings.createBooleanBinding(
    () -> {
        if (cell.getItem() == null) return false ;
        LocalDateTime selected = createDateTime(startDate.getValue(), cell.getItem(),
                    startMinute.getValue(), startMeridian.getValue());
        return selected.isBefore(clock.get());
    }, 
    cell.itemProperty(), 
    startMinute.valueProperty(), 
    startMeridian.valueProperty(), 
    startDate.valueProperty(),
    clock
));
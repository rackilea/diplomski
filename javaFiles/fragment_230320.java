public ObjectProperty<LocalDate> dateFromProperty() {
        if(dateFrom == null){
            dateFrom = new SimpleObjectProperty<>();
        }
        return dateFrom;
    }
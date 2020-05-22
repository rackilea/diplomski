chFiltrar.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
        if (newValue.intValue() == 0) { //30 days
            //I need to show only items where date<last 30 days
            Calendar now = Calendar.getInstance();
            filteredList.setFilter(date -> {
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                return now.add(Calendar.DAY_OF_MONTH, -30).before(date);
            });
        } else if (newValue.intValue() == 2) { //All days
            //This option works well because I show all items
            filteredList.setFilter(date -> true);
        }
    });
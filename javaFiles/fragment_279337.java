final ObservableList<Integer> highlightRows = FXCollections.observableArrayList();

    table.setRowFactory(new Callback<TableView<Person>, TableRow<Person>>() {
        @Override
        public TableRow<Person> call(TableView<Person> tableView) {
            final TableRow<Person> row = new TableRow<Person>() {
                @Override
                protected void updateItem(Person person, boolean empty){
                    super.updateItem(person, empty);
                    if (highlightRows.contains(getIndex())) {
                        if (! getStyleClass().contains("highlightedRow")) {
                            getStyleClass().add("highlightedRow");
                        }
                    } else {
                        getStyleClass().removeAll(Collections.singleton("highlightedRow"));
                    }
                }
            };
            highlightRows.addListener(new ListChangeListener<Integer>() {
                @Override
                public void onChanged(Change<? extends Integer> change) {
                    if (highlightRows.contains(row.getIndex())) {
                        if (! row.getStyleClass().contains("highlightedRow")) {
                            row.getStyleClass().add("highlightedRow");
                        }
                    } else {
                        row.getStyleClass().removeAll(Collections.singleton("highlightedRow"));
                    }
                }
            });
            return row;
        }
    });
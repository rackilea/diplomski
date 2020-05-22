personTable.setRowFactory(tv -> {
    TableRow<Person> row = new TableRow<Person>() {
        @Override
        public void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);
            if (person != null && person.getState() == State.GOODFRIEND) {
                setStyle("-fx-background-color: green;");
            } else {
                setStyle("");
            }
        }
    };
    row.setOnMouseClicked(...);
    return row ;
});
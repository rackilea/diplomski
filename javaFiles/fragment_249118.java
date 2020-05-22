list.setCellFactory(new Callback<ListView<Label>, ListCell<Label>>() {

    @Override
    public ListCell<Label> call(ListView<Label> list) {
        ListCell<Label> cell = new ListCell<Label>() {
            @Override
            public void updateItem(Label item, boolean empty) {
                super.updateItem(item, empty);
                // also sets to graphic to null when the cell becomes empty
                setGraphic(item);
            }
        };

        return cell;
    }
});
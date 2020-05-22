table1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Foo>() {
    private boolean reverting = false;

    @Override
    public void changed(ObservableValue<? extends Foo> observable, Foo oldSelection, Foo newSelection) {
        if (newSelection != null && !reverting) {
            Alert alert = new Alert(AlertType.CONFIRMATION, "Unsaved Data Will be Deleted. Continue" + " ?",
                    ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                //populate table2
            }
            else if (alert.getResult() == ButtonType.NO) {
                 reverting = true;
                 table1.getSelectionModel().select(oldSelection);
            }
        }

        reverting = false;
    }
});
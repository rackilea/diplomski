public final class PairingResultEditingCell extends TableCell<Pairing, Result> {

    private final ChoiceBox<Result> choiceField;

    private PairingResultEditingCell() {

        super();
        this.choiceField = new ChoiceBox<Result>();

        ReadOnlyObjectProperty<TableRow> roop= this.tableRowProperty();
        this.tableRowProperty().addListener(new ChangeListener<TableRow>() {
            @Override
            public void changed(ObservableValue<? extends TableRow> observable, TableRow oldValue, TableRow newValue) {
                choiceField.setVisible(newValue.getItem() != null);
            }
        });
    }
}
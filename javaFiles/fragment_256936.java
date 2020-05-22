public class HistoryRow extends TableRow<History> {

    private static final PseudoClass ERROR = PseudoClass.getPseudoClass("error");

    public HistoryRow() {
        hoverProperty().addListener((o, oldValue, newValue) -> {
            if (newValue) {
                History historyRow = getItem();
                if (historyRow != null && historyRow.isHasError()) {
                    // TODO: display popup here
                } 
            }
        });
    }

    @Override
    protected void updateItem(History history, boolean empty) {
        super.updateItem(history, empty);
        pseudoClassStateChanged(ERROR, !empty && history != null && history.isHasError());
    }

}
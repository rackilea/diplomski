public interface ChoiceItemProvider<S, T> {
    ObservableList<T> getItems(S source);
}

public class DynamicChoiceBoxTableCell<S, T> extends ChoiceBoxTableCell<S, T> {

    private ChoiceItemProvider<S, T> provider;

    public DynamicChoiceBoxTableCell(ChoiceItemProvider<S, T> provider) {
        super();
        this.provider = provider;
    }


    /**
     * Not so obvious hook: overridden to update the items of the 
     * choiceBox.
     */
    @Override
    public void startEdit() {
        super.startEdit();
        updateItems();
    }

    /**
     * Obvious hook: override to update the items of the choiceBox.
     * Not fully working - for some reason, the current item isn't
     * selected after starting the edit.
     */
    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        // updateItems();
    }

    /**
     * Dynamically updates the items to current rowItem. 
     */
    @SuppressWarnings("unchecked")
    protected void updateItems() {
        TableRow<S> tableRow = getTableRow();
        S rowItem = tableRow != null ? tableRow.getItem() : null;
        if (provider == null || rowItem == null) return;
        if (provider != null) {
            getItems().setAll(provider.getItems(rowItem));
        } 
    }
}
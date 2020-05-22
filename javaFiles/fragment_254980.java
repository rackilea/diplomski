tableView.getSelectionModel().selectedIndexProperty().addListener(e->{
    int selectedRow = tableView.getSelectionModel().getSelectedIndex();
    //... do all the updating and all that fun stuff.
    tableView.requestFocus();
    tableView.getSelectionModel().select(selectedRow);
    tableView.getFocusModel().focus(selectedRow);
});
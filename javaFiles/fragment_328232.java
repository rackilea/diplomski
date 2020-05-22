public void doSearch(ActionEvent event) {
    String query = searchTextField.getText();
    if (query.isEmpty()) {
        data = FXCollections.observableArrayList(dc.getJobCoachRepo().getList());
        usersTableView.setItems(data);
    } else {

        searchChoiceBox.getValue().accept(query);

    }
}
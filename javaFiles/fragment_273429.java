private void editBtn(ActionEvent event) {
    Test o = testTable.getSelectionModel().getSelectedItem();
    if (o != null) {
        o.setCount(Integer.parseInt(count.getText()));
    }
}
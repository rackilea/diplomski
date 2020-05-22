removeButton1.setOnAction(e -> {
    try {
        Item selectedItem = itemTable.getSelectionModel().getSelectedItem();
        itemTable.getItems().remove(selectedItem);
        inventoryData.removeItem(selectedItem.getItemId());

    } catch (SQLException e1) {
        e1.printStackTrace();
    }
}
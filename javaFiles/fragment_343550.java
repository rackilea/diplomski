@FXML public void dodajRadnikaKlik() throws IOException {

    // if you want to add an item:
    items.add(new radnici(upišiRadnika.getText()));

    // if you want to replace all items with the new one:
    // items.setAll(new radnici(upišiRadnika.getText()));

    upišiRadnika.clear();
    controller.CloseStage();
}
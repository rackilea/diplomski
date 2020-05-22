ListView<String> lv = new ListView<>();

// Make cells editable
lv.setEditable(true);
lv.setCellFactory(TextFieldListCell.forListView());

// print selected item to the console
lv.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    System.out.println("Selected Item: "+ newValue);
});

TextField tf = new TextField();
// add new text from the textfield as item to the listview
tf.setOnAction((event) -> {
    lv.getItems().add(tf.getText());
    tf.clear();
});

VBox root = new VBox(lv, tf);
// TODO: add root to scene
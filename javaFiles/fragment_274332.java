@Override
public void start(Stage primaryStage) throws IOException {
    ListView<Integer> lv1 = new ListView<>();
    ListView<String> lv2 = new ListView<>();
    for (int i = 0; i < 26; i++) {
        lv1.getItems().add(i);
        lv2.getItems().add(Character.toString((char) ('a' + i)));
    }

    lv1.getSelectionModel().selectedIndexProperty().addListener((o, oldValue, newValue) -> {
        int index = newValue.intValue();
        if (index < 0) {
            lv2.getSelectionModel().clearSelection();
        } else {
            lv2.getSelectionModel().select(index);
        }
    });

    Scene scene = new Scene(new HBox(lv1, lv2));

    primaryStage.setScene(scene);
    primaryStage.show();
}
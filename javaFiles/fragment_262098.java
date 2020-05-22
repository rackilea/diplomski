@Override
public void start(Stage primaryStage) {
    Button btn = new Button();
    btn.setText("Choose favorite meal");

    Label label = new Label("I don't know your favorite meal yet!");

    btn.setOnAction((ActionEvent event) -> {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("input.fxml"));
        Scene newScene;
        try {
            newScene = new Scene(loader.load());
        } catch (IOException ex) {
            // TODO: handle error
            return;
        }

        Stage inputStage = new Stage();
        inputStage.initOwner(primaryStage);
        inputStage.setScene(newScene);
        inputStage.showAndWait();

        String meal = loader.<InputController>getController().getMeal();

        label.setText(meal == null ? "C'mon, tell me your favourite meal already!" : "Your favourite meal is "+meal+". Interesting!");
    });

    VBox root = new VBox(label, btn);
    root.setSpacing(10);
    root.setPadding(new Insets(10));
    root.setPrefWidth(300);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}
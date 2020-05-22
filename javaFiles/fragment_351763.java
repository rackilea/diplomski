@Override
public void start(Stage primaryStage) {
    Button btn = new Button("Sort");

    StackPane.setAlignment(btn, Pos.BOTTOM_CENTER);

    TagBar tagBar = new TagBar();

    btn.setOnAction((ActionEvent event) -> {
        FXCollections.sort(tagBar.getTags());
    });

    Button btn2 = new Button("add \"42\"");
    btn2.setOnAction(evt -> {
        if (!tagBar.getTags().contains("42")) {
            tagBar.getTags().add("42");
        }
    });

    VBox root = new VBox();
    root.getChildren().addAll(tagBar, btn, btn2);
    root.setPrefSize(300, 400);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}
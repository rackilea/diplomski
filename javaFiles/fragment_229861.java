@Override
public void start(Stage primaryStage) {
    VBox content = new VBox();
    ScrollPane scrollPane = new ScrollPane(content);
    VBox.setVgrow(scrollPane, Priority.ALWAYS);
    Button button = new Button("fill");
    button.setOnAction(evt -> {
        for (int i = 0; i < 20; i++) {
            content.getChildren().add(new Text(Integer.toString(i)));
        }
        System.out.println("content size before layout: " + content.getHeight());

        // manually layout scrollPane
        scrollPane.applyCss();
        scrollPane.layout();

        System.out.println("content size after layout: " + content.getHeight());
        scrollPane.setVvalue(1d);
    });

    Scene scene = new Scene(new VBox(button, scrollPane), 200, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
}
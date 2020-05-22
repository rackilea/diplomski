public void start(Stage stage) {
 Button btn = new Button("Press me");

 Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
    // this code will be called every second
    System.out.println(btn.isPressed() ? "pressed" : "released");
 }));
 timeline.setCycleCount(Timeline.INDEFINITE);
 timeline.play();


 StackPane root = new StackPane();
 root.getChildren().add(btn);

 Scene scene = new Scene(new StackPane(btn), 300, 250);
 stage.setTitle("Hello World!");
 stage.setScene(scene);
 stage.show();
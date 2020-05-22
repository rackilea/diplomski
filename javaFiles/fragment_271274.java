@Override
public void start(Stage primaryStage) {
    CircularPane pane = new CircularPane(200,20,10);
    for(int i = 0; i < 6; i++) {
        Button button = new Button("" + (i+1));
        pane.getChildren().add(button);
    }
    Circle circle = new Circle(200);
    circle.setFill(null);
    circle.setStroke(Color.BLACK);
    StackPane stack=new StackPane(circle,pane);
    Scene scene = new Scene(stack, 500, 500);

    primaryStage.setScene(scene);
    primaryStage.show();
}
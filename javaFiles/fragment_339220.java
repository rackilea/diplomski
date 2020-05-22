@Override
public void start(Stage primaryStage) throws Exception{
    method();
}

private void method(){
    StackPane stack = new StackPane();
    Scene scene = new Scene(stack, 400, 400);
    Beginning.setScene(scene);
    Beginning.setTitle("Start here");

    VBox rows = new VBox();
    rows.setAlignment(Pos.CENTER);
    rows.setSpacing(50);
    stack.getChildren().add(rows);
    // and so one
}
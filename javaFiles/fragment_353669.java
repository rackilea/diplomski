final Circle circle = new Circle(…);
final Text text = new Text (…);
final StackPane stack = new StackPane();
stack.getChildren().addAll(circle, text);
…
stack.setLayoutX(30);
stack.setLayoutY(30);
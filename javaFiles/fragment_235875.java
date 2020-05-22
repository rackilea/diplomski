@Override
public void start(Stage primaryStage) {
    GridPane root = new GridPane();
    root.addRow(0, new Circle(50, Color.GREEN), new Circle(50, Color.YELLOW), new Circle(50, Color.RED));
    root.addRow(1, new Rectangle(50, 50), new Rectangle(50, 50), new Rectangle(50, 50));

    Board board = new Board(root);

    EventHandler<MouseEvent>[] handlers = new EventHandler[] {
        board.new CircleEventHandler(),
        board.new RectangleEventHandler()
    };

    for (Node n : root.getChildren()) {
        n.setOnMouseClicked(handlers[GridPane.getRowIndex(n)]);
    }

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}
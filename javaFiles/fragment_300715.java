private static void registerListeners(final Label label, Node... nodes) {
    final EventHandler<MouseEvent> enteredHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            label.setCursor(Cursor.HAND);
            label.setText("Hovered!");
        }
    };

    final EventHandler<MouseEvent> exitedHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            label.setCursor(Cursor.MOVE);
            label.setText("Bored");
        }
    };

    // add listeners to all nodes
    for (Node n : nodes) {
         n.setOnMouseEntered(enteredHandler);
         n.setOnMouseExited(exitedHandler);
    }
}
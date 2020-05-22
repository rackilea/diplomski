class DragablePath extends Group {

    private final Node node;

    DragablePath(Node node) {
        this.node = node;
        this.getChildren().add(node);
        final DragContext dragContext = new DragContext();
        this.addEventFilter(
                MouseEvent.ANY,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(final MouseEvent mouseEvent) {
                        mouseEvent.consume();

                    }
                });
       this.addEventFilter(
                MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(final MouseEvent mouseEvent) {
                        node.setEffect(new DropShadow(20, Color.BLACK));

                    }
                });
        this.addEventFilter(
                MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(final MouseEvent mouseEvent) {
                        node.setEffect(null);

                    }
                });

        this.addEventFilter(
                MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(final MouseEvent mouseEvent) {
                        dragContext.mouseAnchorX = mouseEvent.getX();
                        dragContext.mouseAnchorY = mouseEvent.getY();
                        dragContext.initialTranslateX = node.getTranslateX();
                        dragContext.initialTranslateY = node.getTranslateY();

                    }
                });
        this.addEventFilter(
                MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(final MouseEvent mouseEvent) {

                        node.setTranslateX(
                                dragContext.initialTranslateX
                                + mouseEvent.getX()
                                - dragContext.mouseAnchorX);
                        node.setTranslateY(
                                dragContext.initialTranslateY
                                + mouseEvent.getY()
                                - dragContext.mouseAnchorY);

                    }
                });
        this.addEventFilter(
                MouseEvent.MOUSE_RELEASED,
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(final MouseEvent mouseEvent) {

                    }
                });

    }
}

private static final class DragContext {

    public double mouseAnchorX;
    public double mouseAnchorY;
    public double initialTranslateX;
    public double initialTranslateY;

}
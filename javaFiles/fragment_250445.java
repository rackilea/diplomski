public class MouseGestures {

    final DragContext dragContext = new DragContext();

    public void makeDraggable(final Node node) {

        node.setOnMousePressed(onMousePressedEventHandler);
        node.setOnMouseDragged(onMouseDraggedEventHandler);
        node.setOnMouseReleased(onMouseReleasedEventHandler);

    }

    EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

            dragContext.x = event.getSceneX();
            dragContext.y = event.getSceneY();

        }
    };

    EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

            Node node = (Node) event.getSource();

            double offsetX = event.getSceneX() - dragContext.x;
            double offsetY = event.getSceneY() - dragContext.y;

            node.setTranslateX(offsetX);
            node.setTranslateY(offsetY);

            // same for the other cards
            List<Card> list = Game.getSelectedCards( (Card) node);
            for( Card card: list) {
                card.setTranslateX(offsetX);
                card.setTranslateY(offsetY);
            }


        }
    };

    EventHandler<MouseEvent> onMouseReleasedEventHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

            Node node = (Node) event.getSource();

            moveToSource(node);

            // same for the other cards
            List<Card> list = Game.getSelectedCards( (Card) node);
            for( Card card: list) {
                moveToSource(card);
            }

            // if you find out that the cards are on a valid position, you need to fix it, ie invoke relocate and set the translation to 0
            // fixPosition( node);

        }
    };

    private void moveToSource( Node node) {
        double sourceX = node.getLayoutX() + node.getTranslateX();
        double sourceY = node.getLayoutY() + node.getTranslateY();

        double targetX = node.getLayoutX();
        double targetY = node.getLayoutY();

        Path path = new Path();
        path.getElements().add(new MoveToAbs( node, sourceX, sourceY));
        path.getElements().add(new LineToAbs( node, targetX, targetY));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setNode(node);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(true);

        pathTransition.play();
    }

    /**
     * Relocate card to current position and set translate to 0.
     * @param node
     */
    private void fixPosition( Node node) {

        double x = node.getTranslateX();
        double y = node.getTranslateY();

        node.relocate(node.getLayoutX() + x, node.getLayoutY() + y);

        node.setTranslateX(0);
        node.setTranslateY(0);

    }

    class DragContext {

        double x;
        double y;

    }

    // pathtransition works with the center of the node => we need to consider that
    public static class MoveToAbs extends MoveTo {

        public MoveToAbs( Node node, double x, double y) {
            super( x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2, y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);

        }

    }

    // pathtransition works with the center of the node => we need to consider that
    public static class LineToAbs extends LineTo {

        public LineToAbs( Node node, double x, double y) {
            super( x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2, y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
        }

    }

}
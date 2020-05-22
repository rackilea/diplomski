public class Board {

    public Board(GridPane grid) {
        this.grid = grid;
    }

    private final GridPane grid;
    private Circle selectedCircle;

    public class CircleEventHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            // store info about circle clicked in enclosing instance
            selectedCircle = (Circle) event.getSource();
        }

    }

    public class RectangleEventHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {

            if (selectedCircle != null) {
                // use field of enclosing instance to retrieve color of the circle
                Rectangle r = (Rectangle) event.getSource();
                r.setFill(selectedCircle.getFill());
                selectedCircle = null;
            }

        }

    }

}
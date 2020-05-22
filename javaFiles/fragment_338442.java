public class SnakeGameCell extends JComponent {

    private boolean snakePresent;

    public boolean isSnakePresent() {
        return snakePresent;
    }

    public void setSnakePresent(boolean present) {
        if (snakePresent != present) {
            snakePresent = present;
            repaint();
        }
    }

}
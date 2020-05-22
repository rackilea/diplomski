import java.awt.Robot;

...

Robot robot = new Robot(<your GraphicsDevice>);

...

@Override
public void mouseMoved(MouseEvent e) {
    int x = e.getX(), y = e.getY();
    if(shape.contains(x, y)) {
        mouseMoveX = e.getX();
        mouseMoveY = e.getY();
    }
    else {
        robot.mouseMove(mouseMoveX,mouseMoveY); // Assuming these are the previous coordinates.
    }
}
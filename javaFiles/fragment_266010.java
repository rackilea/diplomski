public class Board extends JPanel {


int x; // Mouse pointer fields.
int y;

public Board() {

            blah blah

    MouseHandler handler = new MouseHandler();
    addMouseMotionListener(handler);

}


static class MouseHandler implements MouseMotionListener {
    int pointerX;
    int pointerY;

    public void mouseMoved(MouseEvent e) {
       Board b = (Board) e.getSource();
       b.setX(e.getX()); 
       b.setY(e.getY());
    }

}
}
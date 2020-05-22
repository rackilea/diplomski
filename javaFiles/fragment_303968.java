public class DragRectangle extends Applet implements MouseMotionListener, MouseListener {

boolean clicked_in_rectangle = false, dragStarted = false;

int x, y, px, py;
Rectangle rect = new Rectangle(0, 0, 80, 50);

public void init() {
    addMouseMotionListener(this);
    addMouseListener(this);
}

public void paint(Graphics g) {
    if (clicked_in_rectangle) {
        int nx = rect.x + (x - px);
        int ny = rect.y + (y - py);

        Rectangle bounds = g.getClipBounds();
        boolean reset = false;
        if (nx + rect.width > bounds.width || nx < 0) {
            nx = rect.x;
            reset = true;
        }
        if (ny + rect.height > bounds.height || ny < 0) {
            ny = rect.y;
            reset = true;
        }
        if (reset) {
            px = 0;
            py = 0;
        } else {
            px = x;
            py = y;
        }

        rect = new Rectangle(nx, ny, rect.width, rect.height);
    }
    g.drawRect(rect.x, rect.y, rect.width, rect.height);

}

public void mouseDragged(MouseEvent e) {
    if (dragStarted) {
        x = e.getX();
        y = e.getY();
        if (px == 0 && py == 0) {
            px = x;
            py = y;
        } else {
            clicked_in_rectangle = new Rectangle(x, y, 1, 1).intersects(rect);
            if (clicked_in_rectangle) {
                repaint();
            }
        }
    }
}

public void mouseMoved(MouseEvent e) {

}

@Override
public void mouseClicked(MouseEvent e) {
}

@Override
public void mouseEntered(MouseEvent e) {
}

@Override
public void mouseExited(MouseEvent e) {
}

@Override
public void mousePressed(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
        dragStarted = new Rectangle(e.getX(), e.getY(), 1, 1).intersects(rect);
    }
}

@Override
public void mouseReleased(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
        px = 0;
        py = 0;
    }
}

}
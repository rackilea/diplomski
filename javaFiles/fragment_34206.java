private JPanel clicked;

@Override
public void mouseClicked(MouseEvent e) {

    if (clicked != null) {
        clicked.setLocation(e.getX(), e.getY());
        clicked = null;
    } else {
        // Figure out if any panel was clicked and assign
        // a reference to clicked
    }

}
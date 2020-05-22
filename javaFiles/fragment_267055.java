class Help_Option extends JComponent implements MouseListener, MouseMotionListener {
    Ellipse2D ellipse = ...;

    public Help_Option() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void mouseMoved(MouseEvent e) {
        if (ellipse.contains(e.getX(), e.getY()) ) {
            //mouse is inside the ellipse
        } else {
            //mouse is outside the ellipse
        }
    }

    public void mouseExited(MouseEvent e) {
        //mouse is outside the ellipse
    }

    //more method stubs
}
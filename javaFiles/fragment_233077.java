// A graphical component displaying the model.
// Object of this class are interested in movement because when the image moves,
// this component needs to be repainted.
class ImgComponent extends JComponent implements ChangeListener {

    // The movable image to present.
    MovableImage mi;

    public ImgComponent(MovableImage mi) {
        this.mi = mi;
        mi.addListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mi.i, mi.getX(), 10, null);
    }

    // This method is called from MovableImage when the position changes.
    @Override
    public void stateChanged(ChangeEvent e) {
        repaint();
    }
}
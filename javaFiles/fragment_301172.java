public class ImageButton extends JButton {

    static final long serialVersionUID = 1;

    public ImageButton(Image image, Dimension imageSize) {
        super(new ImageIcon(image));
        this.setMinimumSize(imageSize);
        this.setPreferredSize(imageSize);
        this.setMaximumSize(imageSize);
        this.setVisible(true);
    }

    public void addMouseMotionListener() {
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent mouseEvent) {
                // do a bunch of stuff
            }

            @Override
            public void mouseMoved(java.awt.event.MouseEvent mouseEvent) {}
        });
    }   
}
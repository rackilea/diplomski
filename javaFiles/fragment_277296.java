public class ButtonPanel extends JPanel {

    Image img;

    public ButtonPanel() {
        img = (Settings.background).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Settings.width, Settings.height);

    }
}
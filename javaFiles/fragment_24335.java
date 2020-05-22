public class TestPanel extends JPanel {

private Image image;

public TestPanel() {
image = ImageIO.read(new File(asset));
}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
                if(asset!=null) {
                    g.drawImage(image, 0, 0, null);
                }
    }
}
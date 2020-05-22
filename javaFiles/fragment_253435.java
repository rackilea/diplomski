public class BackgroundPanel extends JPanel {
    private BufferedImage bgImg;

    public BackgroundPanel() {
        try {
            bgImg = ImageIO.read(BackgroundPanel.class.getResourceAsStream(
                    "mybackgroundimage.png"));
        } catch (IOException ex) {
            System.err.println("Could not load background image!");
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bgImg != null) {
            g.drawImage(bgImg, 0, 0, null);
        }
    }
}

public class MyJFrame extends JFrame {

    public MyJFrame() {
        setContentPane(new BackgroundPanel());
    }

}
public class BackGroundProblem {
    public static void main(String[] args) throws IOException {

        final Image image = ImageIO.read(new URL("http://news.beloblog.com/ProJo_Blogs/architecturehereandthere/hallstattsumm.jpg"));
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                JPanel backgroundPanel = new ImagePanel(image);
                backgroundPanel.add(new JButton("Sample Button 1"));
                backgroundPanel.add(new JButton("Sample Button 2"));
                frame.add(backgroundPanel);
                frame.setLocationByPlatform(true);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class ImagePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image image;

    ImagePanel(Image image) {
        this.image = image;
    };

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}
public class CardDisplay extends JComponent {
    private BufferedImage cardImage;

    public CardDisplay() {
        try {
            cardImage = ImageIO.read(new File("Phase10//res//Blue2.png"));
        } catch (final IOException e) {
            e.printStackTrace();
        }    
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(cardImage, 0, 0, null);
    }

    @Override
    public Dimension getPreferredSize() {
        if (cardImage == null) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(cardImage.getWidth(null), cardImage.getHeight(null));
        }
    }

    public static class View {
        public View() {}

        public void makeFrame() {
            final JFrame frame = new JFrame("Phase 10");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            final JPanel handPanel = new JPanel();
            final CardDisplay cd = new CardDisplay();
            handPanel.setLayout(new FlowLayout());
            frame.add(handPanel, BorderLayout.SOUTH);
            handPanel.add(cd);
            frame.pack();
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }

    public static void main(final String[] args) {
        final View view = new View();
        view.makeFrame();
    }
}
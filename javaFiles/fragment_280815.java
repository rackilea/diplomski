public class TestTranslucentControls {

    public static void main(String[] args) {
        new TestTranslucentControls();
    }

    public TestTranslucentControls() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage background;

        public TestPane() {
            setLayout(new GridBagLayout());
            try {
                background = ImageIO.read(new File("C:/Users/shane/Dropbox/MegaTokyo/poster.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            add(new JButton("1"));
            add(new JButton("2"));
            add(new JButton("3"));
            add(new JButton("4"));
            add(new JButton("5"));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setComposite(AlphaComposite.SrcOver.derive(0.25f));
                int x = (getWidth() - background.getWidth()) / 2;
                int y = (getHeight() - background.getHeight()) / 2;
                g2.drawImage(background, x, y, this);
                g2.dispose();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? new Dimension(300, 300) : new Dimension(background.getWidth(), background.getHeight());
        }
    }
}
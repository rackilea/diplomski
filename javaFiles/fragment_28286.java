public class TestSaveFrame extends JFrame {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }
                new TestSaveFrame();
            }
        });
    }

    public TestSaveFrame() {

        setTitle("Save me");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        BackgroundPane pane = new BackgroundPane();
        pane.setLayout(new GridBagLayout());

        JLabel label = new JLabel("I'm sitting on top");
        label.setFont(label.getFont().deriveFont(Font.BOLD, 24f));
        label.setForeground(Color.WHITE);

        pane.add(label);

        add(pane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                    Container content = getContentPane();
                    BufferedImage img = new BufferedImage(content.getWidth(), content.getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2d = img.createGraphics();
                    content.printAll(g2d);
                    g2d.dispose();

                    try {
                        ImageIO.write(img, "png", new File("C:/PrintMe.png"));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }

    public class BackgroundPane extends JPanel {

        private Image background = null;

        public BackgroundPane() {
            try {
                background = ImageIO.read(getClass().getResource("/MT015.jpg"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? new Dimension(200, 200) : new Dimension(background.getWidth(this), background.getHeight(this));
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            if (background != null) {
                int x = (getWidth() - background.getWidth(this)) / 2;
                int y = (getHeight() - background.getHeight(this)) / 2;

                g.drawImage(background, x, y, this);
            }
        }
    }
}
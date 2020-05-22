public class TestButtons {

    public static void main(String[] args) {
        new TestButtons();
    }

    public TestButtons() {
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
                frame.add(new ButtonPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ButtonPane extends JPanel {

        public ButtonPane() {

            setLayout(new GridLayout(10, 2, 0, 0));

            BufferedImage img = new BufferedImage(18, 18, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(Color.RED);
            g2d.fillRect(0, 0, 18, 18);
            g2d.dispose();

            for (int ii = 0; ii < 20; ii++) {
                JButton jb1 = new JButton(new ImageIcon(img));
                jb1.setMargin(new Insets(0, 0, 0, 0));
//                jb1.setBorderPainted(false);
                jb1.setContentAreaFilled(false);
                jb1.setFocusPainted(false);
                jb1.setBorder(new EmptyBorder(0, 0, 0, 0));

                add(jb1);
            }
        }
    }
}
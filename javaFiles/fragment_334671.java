public class TestLayout17 {

    public static void main(String[] args) {
        new TestLayout17();
    }

    public TestLayout17() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
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

        /*
         * Background Section
         */
        JPanel panel1 = new JPanel();
        JLabel lbl1 = new JLabel();
        /*
         * Component Section
         */
        JPanel panel2 = new JPanel();
        JLabel lbl2 = new JLabel();
        /*
         * Dimension Section
         */
        Dimension windowSize = new Dimension(800, 600);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        public TestPane() {

            setLayout(new BorderLayout());

            panel1.setLayout(new BorderLayout());

            lbl1.setLayout(new BorderLayout());
            URL url = getClass().getResource("/bg1.gif");
            System.out.println(url);
            try {
                BufferedImage image = ImageIO.read(url);
                Image smaller = image.getScaledInstance(-1, image.getHeight() / 2, Image.SCALE_SMOOTH);
                lbl1.setIcon(new ImageIcon(smaller));
            } catch (Exception e) {
                e.printStackTrace();
            }
//            lbl1.setIcon(new ImageIcon(url));
            panel1.add(lbl1);

            add(panel1);

            panel2.setLayout(new GridBagLayout());
            panel2.setOpaque(false);

            lbl2.setBorder(new EmptyBorder(8, 8, 8, 8));
            lbl2.setBackground(Color.GREEN);
            lbl2.setText("Say hello");;
            lbl2.setOpaque(true);
            panel2.add(lbl2);

            lbl1.add(panel2);

        }
    }
}
public class TryOut1 extends JFrame {

    public TryOut1() {
        try {
            screen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        buttonDoor();

        setSize(1280, 1024);
    }

    public void screen() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        File desktop = new File(System.getProperty("user.home"), "Desktop");
        File backgroundImg = new File(desktop, "background.png");
        Image img = ImageIO.read(backgroundImg);
        JPanel contentPane = new JPanel(new FlowLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        };
        setContentPane(contentPane);
    }

    public void buttonDoor() {
        File desktop = new File(System.getProperty("user.home"), "Desktop");
        File doorFile = new File(desktop, "door.png");
        JButton b1 = new JButton(new ImageIcon(doorFile.getAbsolutePath()));
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.setBorderPainted(false);
        add(b1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String args[]) {
        // All swing apps must run in their own thread.
        SwingUtilities.invokeLater(() -> new TryOut1().setVisible(true));
    }
}
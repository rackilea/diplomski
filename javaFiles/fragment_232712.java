private BufferedImage splash;

/**
 * Create the frame.
 */
public Splash() {
    this.setUndecorated(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setSize(500, 500);
    setLocationRelativeTo(null);

    try {
        splash = ImageIO.read(getClass().getResource("/images/transparent.png"));
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Apply a transparent color to the background
    // This is REALLY important, without this, it won't work!
    setBackground(new Color(0, 255, 0, 0));
    getContentPane().setBackground(Color.BLACK);
    add(new JLabel(new ImageIcon(splash)));
    setVisible(true);
}
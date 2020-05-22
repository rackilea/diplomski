public class GTest extends JFrame implements ActionListener {
    private Color textColor = Color.BLACK;
    private Random random = new Random();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(textColor);
        g.drawString("[Game goes here]", 100, 150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textColor = new Color(random.nextInt(0x00ffffff));
        repaint();
    }

    public GTest() {
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 3,
                Toolkit.getDefaultToolkit().getScreenSize().width / 3 + 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Timer timer = new Timer(500, this);
        timer.setInitialDelay(0);
        timer.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        GTest myWindow = new GTest();
    }
}
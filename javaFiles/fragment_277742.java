public class TestPane extends JLabel {

    public TestPane() {
        setText("Happy, Happy");
        setForeground(Color.WHITE);
        setHorizontalAlignment(CENTER);
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        LinearGradientPaint lgp = new LinearGradientPaint(
                new Point(0, 0), 
                new Point(0, getHeight()), 
                new float[]{0.142f, 0.284f, 0.426f, 0.568f, 0.71f, 0.852f, 1f}, 
                new Color[]{Color.PINK, Color.MAGENTA, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED});
        g2d.setPaint(lgp);
        g2d.fill(new Rectangle(0, 0, getWidth(), getHeight()));
        g2d.dispose();
        getUI().paint(g, this);
    }

}
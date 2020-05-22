public class CirclePanel extends JPanel{

    public static final Color circleColor = Color.BLACK;

    private boolean drawCircle;

    public CirclePanel() {
        drawCircle=false;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
    }

    public void setDrawCircle(boolean drawCircle) {
        this.drawCircle = drawCircle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(drawCircle) {

            Graphics2D g2d = (Graphics2D) g;
            Color tmp = g2d.getColor();
            g2d.setColor(circleColor);

            g2d.fillOval(0, 0, getWidth(), getHeight());

            g2d.setColor(tmp);
        }
    }
}
public class Elevator extends JPanel {

    private int y = 0;
    private int delta = 1;
    private Color fillColor;

    public Elevator(Color color, boolean goingDown) {
        fillColor = color;

        if (goingDown) {
            y = 0;
            delta = 1;
        } else {
            y = getPreferredSize().height - 120;
            delta = -1;
        }

        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y += delta;
                if (y + 120 > getHeight()) {
                    y = getHeight() - 120;
                    delta *= -1;
                } else if (y < 0) {
                    y = 0;
                    delta *= -1;
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(81, 120 * 3);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(fillColor);
        g.drawRect(0, y, 80, 120);
    }

}
public class MovingRectangle extends JPanel {
    private Timer timer = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            rectWidth += 100;
            repaint();
        }
    };

    private int rectWidth = 100;

    public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawRect(0, 0, 100. rectWidth);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void reset() {
        rectWidth = 100;
        repaint();
    }
}
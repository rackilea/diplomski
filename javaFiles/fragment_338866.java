public static void main(String[] args) {

    final Triangle t = new Triangle(20, 30, 40);
    final Point translation = new Point(100, 400);

    JFrame frame = new JFrame("Test");

    frame.add(new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Point[] p = t.triangle();

            g.translate(translation.x, translation.y);

            for (int i = 0; i < p.length; i++)
                g.drawLine(p[i].x, 
                           p[i].y, 
                           p[(i+1) % p.length].x, 
                           p[(i+1) % p.length].y);
        }
    });

    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

}
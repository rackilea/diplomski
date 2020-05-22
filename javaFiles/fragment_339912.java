public void paintComponent(Graphics g) {
   super.paintComponent(g);
   Graphics2D g2d = (Graphics2D)g;
   // Assume x, y, and diameter are instance variables.
   Ellipse2D.Double circle = new Ellipse2D.Double(x, y, diameter, diameter);
   g2d.fill(circle);
   ...
}
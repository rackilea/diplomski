@Override // don't forget this
protected void paintComponent(Graphics g) { // spelling matters. Also make it protected

    // !!!! don't forget this!
    super.paintComponent(g); // to have the JPanel do housekeeping painting

    Graphics2D g2d = (Graphics2D) g;

    int red = (int) (Math.random() * 256);
    int green = (int) (Math.random() * 256);
    int blue = (int) (Math.random() * 256);
    Color startColor = new Color(red, green, blue);

    red = (int) (Math.random() * 256);
    green = (int) (Math.random() * 256);
    blue = (int) (Math.random() * 256);
    Color endColor = new Color(red, green, blue);

    GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
    g2d.setPaint(gradient);
    g2d.fillOval(70, 70, 100, 100);
}
protected void paintComponent(Graphics g)
{
    if (isOpaque())
    {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    Graphics2D g2d = (Graphics2D) g;
    // Draw first line
    g2d.setPaint(topLineColor);
    g2d.drawLine(0, 0, this.getWidth(), 0);
    // Draw last line
    g2d.setPaint(bottomLineColor);
    g2d.drawLine(0, 23, this.getWidth(), 23);
    // Draw gradient
    GradientPaint gradient = new GradientPaint(this.getX(), this.getY() + 1, gradientTop, this.getX(), this.getHeight() - 1, gradientBottom);
    g2d.setPaint(gradient);
    g2d.fillRect(this.getX(), this.getY() + 1, this.getWidth(), this.getHeight() - 2);
    if (titleText != null)
    {
        g2d.setFont(new Font("", Font.BOLD, 13));
        g2d.setColor(Color.WHITE);
        g2d.drawString(titleText, 10, 16);
    }
}
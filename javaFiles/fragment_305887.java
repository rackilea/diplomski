@Override 
protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      Font font = new Font("Serif", Font.BOLD, 15);
      g.setFont(font);
      g.setColor(Color.YELLOW);
      g.drawString(string, 0, 0);
}
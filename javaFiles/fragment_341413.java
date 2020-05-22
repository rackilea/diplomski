private void paintInfo() {
    Graphics g = this.getGraphics();
    g.setColor(new Color(222, 222, 222, 4));
    g.setFont(new Font("Arial Black", Font.BOLD, 15));
    g.setColor(Color.BLACK);
    g.drawString("test String ",this.getWidth()/2, this.getHeight()/2);
    g.dispose();
}
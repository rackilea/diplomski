public void paintComponent(Graphics g){
    super.paintComponent(g);
    this.setBackground(Color.WHITE);
    g.setColor(color);
    g.fillRect(15, 25, 100, 20);
    g.drawString("Current color: "+ g.getColor(),130,65);
}
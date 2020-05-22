protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(foregroundImage, x, y, this);
    g.drawString("YOUR BIG STRING");
    jlabel.setBounds(0,0,100,100); //set it to your JLabel bounds...
    jlabel.paint(g);
}
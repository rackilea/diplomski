boolean drawHello = true;
boolean drawWorld = false;

protected void paintComponent(Graphics g) {
    super.paintCompoent(g);
    if (drawHello)
             g.drawString("Hello", 50, 50);

    if (drawWorld)
             g.drawString("World", 10, 10);
}
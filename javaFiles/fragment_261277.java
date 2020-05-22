@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    for (Actor actor : stageActors) {
        actor.render(g2d);
    }
    g2d.drawString("Hello World!", 50, 50);
    g2d.dispose();
}
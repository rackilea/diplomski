@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Actor actor : stageActors) {
        Graphics2D g2d = (Graphics2D) g.create();
        actor.render(g2d);
        g2d.dispose();
    }
    g.drawString("Hello World!", 50, 50);
}
public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    for (int index = 0; index < point.length; index++) {
        Point p = point[index];
        if (p != null) {
            p.y++;
            if (p.y > height) { // You'll need to define height...
                point[index] = null; // Or do something else with it??
            } else {
                m.drawParticle(p.x, p.y);
            }
        }
    }
    g.drawString("Particle Test", 680, 0);
    g.drawString("Build: " + Build, 680, 15);
    g.drawString("Pixels: " + num, 10, 25);
}
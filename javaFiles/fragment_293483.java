for (Bird bird : birds) {
    bird.fly();
    g.setColor(bird.getColor());
    Point pos = bird.getPosition();
    g.fillOval((int)pos.getX()*PIXELS, (int)pos.getY()*PIXELS,
    PIXELS, PIXELS);
    panel.sleep(500);
}
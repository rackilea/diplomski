int time;

public void update(GameContainer container, int delta) {
    time += delta;
}

public void render(GameContainer container, Graphics g) {
    g.drawString("Time : " + time/1000, 100, 100);
}
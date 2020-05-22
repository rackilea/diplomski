boolean running = true;
int frameDelay = 20; // ms

public void stop() { running = false; }

public void run() {
    while (running) {
        try {
            if (block.pos.x < 0 || block.pos.x > 500) {
                velX = -velX;
            }
            block.pos.x += velX;
            repaint();
            Thread.sleep(frameDelay);
        } catch (InterruptedException e) {}
    }
}
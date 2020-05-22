public void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
        this.createBufferStrategy(3);
        return;
    }

    do {
        do {
            Graphics g = bs.getDrawGraphics();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            handler.render(g);
            g.dispose();
        } while (bs.contentsRestored());
        bs.show();
    } while (bs.contentsLost());
}
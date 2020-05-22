private void render() {
    if (getWidth() == 0 || getHeight() == 0) {
        return;
    }
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
        this.createBufferStrategy(3);
        return;
    }
    Graphics g = bs.getDrawGraphics();
}
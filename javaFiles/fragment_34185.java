@Override
public Dimension getPreferredSize() {
    return new Dimension(600, 500);
}

public void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
        createBufferStrategy(3);
        return;
    }
    Graphics g = bs.getDrawGraphics();
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);
    //Background///////////////
    g2d.fillRect(0, 0, getWidth(),getHeight());
    ///////////////////////////
    pris.render(g);
    g.dispose();
    bs.show();

}
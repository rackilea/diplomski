public Game() {
    setContentPane(new DrawPanel());
    getContentPane().setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    pack();

    ...
    //setSize(WIDTH * SCALE, HEIGHT * SCALE);
    ...
}

class DrawPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        draw(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
}
private DrawPanel draw = new DrawPanel();
private int x = 0;
private int y = 0;
public NewJFrame() {
    initComponents();
    setSize(800,600);

    add(draw);
    draw.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            draw.setTemporaryLine(x, y, evt.getX(), evt.getY());
            draw.repaint();
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            x = evt.getX();
            y = evt.getY();
        }
    });
    draw.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            draw.drawTemporaryLine(x, y, evt.getX(), evt.getY());
            draw.repaint();
        }
    });
}
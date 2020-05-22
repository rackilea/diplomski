addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
        pointStart = e.getPoint();
    }
    public void mouseReleased(MouseEvent e) {
        pointStart = null;
    }
});
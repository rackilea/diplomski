public void mouseClicked(MouseEvent event) {
    int targetX = event.getX();
    int targetY = event.getY();
    for(int i=0;i<10;++i) {
        x = (x+targetX)/2;
        y = (y+targetY)/2;
        repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) { }
    }
}
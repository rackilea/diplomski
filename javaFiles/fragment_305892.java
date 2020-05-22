private int startX = -1;
private int startY = -1;

private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
    if (startX == -1 && startY == -1) {
        startX = evt.getX();
        startY = evt.getY();
    } else {
        Graphics g = this.jPanel1.getGraphics();
        g.drawLine(startX, startY, 
                   evt.getX(), evt.getY());
        // reset the start point
        startX = -1;
        startY = -1;
    }
}
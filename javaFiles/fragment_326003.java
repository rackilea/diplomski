private long lastDrawTime = 0;

public void keyPressed(KeyEvent e) {
    if (Calendar.getInstance().getTimeInMillis() - lastDrawTime < 20) return;
    //do whatever needs to be done before redrawing
    draw();
    lastDrawTime = Calendar.getInstance().getTimeInMillis();
}
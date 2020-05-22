class Animation extends Thread {
    /* … */
    public void run() {
        int targetX = event.getX();
        int targetY = event.getY();

        for(int i=0;i<10;++i) {
            panel.x = (panel.x+targetX)/2;
            panel.y = (panel.y+targetY)/2;
            panel.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
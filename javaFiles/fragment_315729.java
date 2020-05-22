public void mouseClicked(MouseEvent e) {
    x=e.getX();
    y=e.getY();
    if(getElementAt(x,y)==null) return;
    currentTower = (GCompound) getElementAt(x,y);
    initThread();
}


private void initThread() {
    new Thread() {
        public void run() {
            ((SignalTower) currentTower).lightTower();
        }
    }.start();
 }

public void lightTower(){
    beacon.setFillColor(Color.red);
    beacon.setFilled(true);
    pause(500);
    beacon.setFilled(false);
    if(this.next!=null) this.next.lightTower();

}
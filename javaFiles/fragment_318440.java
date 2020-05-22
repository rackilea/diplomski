public synchronized boolean checkAndMove(int xi, int yi, int xf, int yf) {
    boolean ok = this.asksAccess(xi, yi, xf, yf);
    if (ok) {
        this.releaseCell(xi, yi);
        this.blockCell(xi, yi);
    }
    return ok;
}
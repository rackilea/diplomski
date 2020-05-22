synchronized(this) {
    c = _surfaceHolder.lockCanvas(null);
    synchronized (_surfaceHolder) {

        if(_suspended)
            this.wait();

        else {
            _battleEarthView.onDraw(c);
        }
    }
}
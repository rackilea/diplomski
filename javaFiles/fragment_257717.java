public Graphic() {
    addKeyListener(this);
    setFocusTraversalKeysEnabled(true);
    setFocusable(true);
    grabFocus();     
    timer = new Timer(delay, this);
    timer.start();
    this.setSize(width, height);
}
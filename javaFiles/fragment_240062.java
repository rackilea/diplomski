public RotatingHexagon() {
    setPreferredSize(new Dimension(800,600));
    setFocusable(true);
    requestFocus();
    addKeyListener(this);
}

public void init() {
    poly = new Polygon(xpoints, ypoints, xpoints.length);        
}
public JMapController(JMapViewer map) {
    this.map = map;
    if (this instanceof MouseListener)
        map.addMouseListener((MouseListener) this);
    …
}
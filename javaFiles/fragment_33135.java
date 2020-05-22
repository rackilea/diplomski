class MyPanel extents Panel implements ComponentListner {
    public MyPanel() {
        addComponentListener(this);
    }
    public void componentResized(ComponentEvent e) {
        paint(getGraphics());
    }
}
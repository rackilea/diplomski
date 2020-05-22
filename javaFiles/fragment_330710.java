List<Point> pointsToDrawSmallerImage = new ArrayList<Point>();

...

listener = new MouseAdapter() {
    public void mouseClicked(MouseEvent evt ) {
        pointsToDrawSmallerImage.add( evt.getPoint() );
        repaint();
    }
}
...

public void paintComponent(Graphics g) {
    g.clear();   // clear the canvas
    for( Point p : pointsToDrawSmallerImage ) {
       g.drawImage(img, p.x, p.y, myCanvas);           
    }
}
public void BoundaryFill(int initialX, int initialY, Color bColor, Color fColor){
    Stack<Point> points = new Stack<>();
    points.add(new Point(initialX, initialY));

    while(!points.isEmpty()) {
        Point currentPoint = points.pop();
        int x = currentPoint.x;
        int y = currentPoint.y;

        int current = bI.getRGB(x, y);
        if((current != bColor.getRGB()) && (current != fColor.getRGB())){
            //bI.setRGB(x, y, fColor.getRGB());
            bI.setRGB(x, y, fColor.getRGB());

            repaint();

            points.push(new Point(x+1, y));
            points.push(new Point(x-1, y));
            points.push(new Point(x, y+1));
            points.push(new Point(x, y-1));
        }
    }
}
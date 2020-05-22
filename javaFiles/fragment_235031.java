MouseAdapter mouseHandler = new MouseAdapter() {

    // detects when mouse was moved
    public void mouseMoved(MouseEvent e) {
        int width = getWidth(); // gets screen resolution e.g. 640x 480
        int height = getHeight();
        // System.out.println(width + " x " +height );

        int cellWidth = width / columnSize; // size of the cell in pixels e.g 32x24
        int cellHeight = height / rowSize;
        // System.out.println(cellWidth + " x " +cellHeight );

        int column = e.getX() / cellWidth; // gets specific cell e.g. (14,14)
        int row = e.getY() / cellHeight;
        // System.out.println("col " +column + " " + row);

        // This is the x/y position of the mouse when the event
        // was triggered
        Point mp = e.getPoint();
        for (Rectangle cell : allowedCells) {
            if (cell.contains(mp)) {
                // Do what ever you want to do here...
            }
        }

        selectedCell = new Point(column, row); // point to represent xy location
        repaint(); // repaint forest
    }
};
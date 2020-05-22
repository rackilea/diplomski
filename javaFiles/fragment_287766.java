// Adds initial 3 2DRectangles to snake at start of game
    public void formSnake() {
        for (int i = 0; i < 3; i++) {
            xloc.add(xCoord);
            yloc.add(yCoord - 16 * i);
            rects.add(rects.size(),
                            new Rectangle2D.Double(xloc.get(i), yloc.get(i), 15, 15));
        }
    }
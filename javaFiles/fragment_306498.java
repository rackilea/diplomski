private class MouseLsntr extends MouseAdapter {
    private int dragStartX, dragStartY;
    private boolean dragging;

    @Override
    public void mouseClicked(MouseEvent me) {
        int x = me.getX() / grid.getPixelsPerTile();
        int y = me.getY() / grid.getPixelsPerTile();
        switch (me.getButton()) {
            case MouseEvent.BUTTON1:
                if (grid.getTile(x, y) != TileType.WALL) {
                    grid.setTile(x, y, TileType.WALL);
                    System.out.println(String.format("(%d, %d) (%d, %d) wall", x, y, x, y));
                } else {
                    grid.removeTile(x, y);
                    System.out.println(String.format("(%d, %d) (%d, %d) blank", x, y, x, y));
                }
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        switch (me.getButton()) {
            case MouseEvent.BUTTON1:
                // Save the drag starting position.
                this.dragStartX = me.getX() / grid.getPixelsPerTile();
                this.dragStartY = me.getY() / grid.getPixelsPerTile();
                this.dragging = true;

                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        switch (me.getButton()) {
            case MouseEvent.BUTTON1:
                if (this.dragging) {
                    moveTile(me);
                }
                this.dragging = false;

                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        this.dragging = false;
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (this.dragging) {
            moveTile(me);
        }
    }

    private void moveTile(MouseEvent me) {
        int dragEndX = me.getX() / grid.getPixelsPerTile();
        int dragEndY = me.getY() / grid.getPixelsPerTile();

        TileType dragStartType = grid.getTile(this.dragStartX, this.dragStartY);
        TileType dragEndType = grid.getTile(dragEndX, dragEndY);
        // If the starting tile was either START or END, move the tile to the destination.
        if ((dragEndType == TileType.BLANK || dragEndType == null) &&
            (dragStartType == TileType.START || dragStartType == TileType.END)) {

            grid.removeTile(this.dragStartX, this.dragStartY);
            grid.setTile(dragEndX, dragEndY, dragStartType);

            // update the drag starting points
            this.dragStartX = dragEndX;
            this.dragStartY = dragEndY;
        }
    }
}
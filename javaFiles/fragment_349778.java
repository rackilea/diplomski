private final int boxSize = 60;
private final int connectorSize = 20;
private final int topOffset = 50;
private final int leftOffset = 50;
private Color roomColor = null;
private Color wallColor = null;
private Color doorColor = null;

private void drawMaze(PaintEvent e) {
    GC gc = e.gc;
    int i = 0;
    int level = 25;
    Graph maze = new Graph();

    maze.generateMaze(level);

    gc.setAntialias(SWT.ON);
    gc.setBackground(new Color(e.display, 150, 150, 150));

    while (i < level) {
        Connector connector = maze.getEdgeConnectorByIndex(i);

        gc.setBackground(roomColor);

        Room room1 = connector.getFirstRoom();
        Room room2 = connector.getSecondRoom();

        // left top corner X of room is offset from left side + coordinate mul size of box plus number of connectors between boxes already drawn before current room mul connector size
        int roomX = leftOffset + room1.getXcoordinate() * boxSize + (room1.getXcoordinate() - 1) * connectorSize;
        // left top corner Y of room is offset from top + coordinate mul size of box plus number of connectors between boxes already drawn above current room mul connector size
        int roomY = topOffset + room1.getYcoordinate() * boxSize + (room1.getYcoordinate() - 1) * connectorSize;

        gc.fillRectangle(roomX, roomY, boxSize, boxSize);

        if (connector instanceof Door) gc.setBackground(doorColor);
        if (connector instanceof Wall) gc.setBackground(wallColor);

        int connectorX = 0;
        int connectorY = 0;
        int connectorWidth = 0;
        int connectorHeight = 0;

        // room have same X, second is above or under the first
        if (room1.getXcoordinate() == room2.getXcoordinate()) {
            connectorWidth = boxSize;
            connectorHeight = connectorSize;
            connectorX = roomX;
            // check if it's under
            if (room1.getYcoordinate() > room2.getYcoordinate()) connectorY = roomY - connectorSize;
            else connectorY = roomY + boxSize;
        }
        // room have same Y, second is on right or left side of the first
        else {
            connectorWidth = connectorSize;
            connectorHeight = boxSize;
            connectorY = roomY;
            // check if it's right side
            if (room1.getXcoordinate() > room2.getXcoordinate()) connectorX = roomX - connectorSize;
            else connectorX = roomX + boxSize;
        }

        gc.fillRectangle(connectorX, connectorY, connectorWidth, connectorHeight);

        // draw the second room
        gc.setBackground(roomColor);

        roomX = leftOffset + room2.getXcoordinate() * boxSize + (room2.getXcoordinate() - 1) * connectorSize;
        roomY = topOffset + room2.getYcoordinate() * boxSize + (room2.getYcoordinate() - 1) * connectorSize;

        gc.fillRectangle(roomX, roomY, boxSize, boxSize);

        i++;
    }
}
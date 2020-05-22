public void showMovementCase(){
    // probably want to remove anything left over from the last invocation
    panel.removeAll();
    for (JLabel[] array : actionSquare) Arrays.fill(array, null);
     
    colorSquares(moveAllowed + attackDistance, redsquare, null);
    colorSquares(moveAllowed * 2, bluesquare, mouse);
     
    for (int x = 0; x < actionSquare.length; x++)
        for (int y = 0; y < actionSquare[x].length; y++)
            if (actionSquare[x][y] != null) panel.add(actionSquare[x][y], 1);
}
 
private void colorSquares(int move, Icon color, MouseListener mouse) {
    int xMax = Math.min(2 * move, actionSquare.length);
    int yMax = Math.min(2 * move, actionSquare[0].length);
    for (int x = 0; x < xMax; x++) {
        for (int y = 0; y < yMax; y++) {
            if (isLegal(x, y, move)) {
                if (actionSquare[x][y] == null)
                    actionSquare[x][y] = new JLabel();
                actionSquare[x][y].setIcon(color);
                actionSquare[x][y].setBounds(
                        sprite.getX() + (x - move) * 16,
                        sprite.getY() + (y - move) * 16, 16, 16 );
                if (mouse != null) actionSquare[x][y].addMouseListener(mouse);
            }
        }
    }
}
 
private static boolean isLegal(int x, int y, int move) {
    // informative comment explaining why this mess makes sense
    if (move <= y+x && move >= y-x && x <= move) return true;
    // informative comment explaining why this mess makes sense
    if (move <= y+x && move >= x-y && x > move && y <= move) return true;
    // informative comment explaining why this mess makes sense
    if (move * 3 >= y+x && move >= y-x && x > move &&  y >= move) return true;
     
    return false;
}
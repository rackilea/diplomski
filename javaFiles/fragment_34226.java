int xLoc;
public int getXLoc() {
    int xLoc = (int) (Math.random() * xSize) ;
    ^--- Shadowing the instance variable...
    return xLoc;
}
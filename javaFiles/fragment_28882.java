public Tile(int type, int xCoord, int yCoord) {
    this.type = type;
    this.xCoord = xCoord;
    this.yCoord = yCoord;
    addMouseListener(this); // add this line and it should work
}
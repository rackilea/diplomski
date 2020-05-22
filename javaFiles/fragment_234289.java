if(mouseRclick) {
    if(block[x][y].isUnder()) {
        if(sid != Tile.air) {
            block[x][y].id = sid;
        }
    // added "else"
    } else if(block[x][y].isGround()) {
        block[x][y].id = toWall(sid);
    }
    // Makes sure that it only runs once.
    mouseRclick = false;
}
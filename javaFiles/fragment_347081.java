// Initially all grid cells are un-blocked
boolean[][] gridBlockedByWall = new boolean[MAP_HEIGHT][MAP_WIDTH]; //Replace with your grid size

// Loop over each wall and set array (change depending on your implementation)
for (Rectangle wall: walls) {

    // Here we run over every wall and column covered by this rectangle and set it as blocked
    for (int row = wall.y; row < wall.y + wall.height; row++) {
        for (int col = wall.x; col < wall.x + wall.width; col++) {
            gridBlockedByWall[row][col] = true;
        } 
    }
}
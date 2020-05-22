else if (orientation == Ship.orientationLeft) {
    if (col >= testLength) {
        bFitsOnBoard = true;
    }
// ED: Where's the '}'?

boolean bHitsOtherShips = false;

// Check to see if the ship hits any other ships on the board.
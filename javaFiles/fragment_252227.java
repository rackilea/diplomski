} else if (x1 < x2 && y1 > y2) { // diagonal northeast
    for (int i = x2 - x1; i > 0; i--) {
        if (piecePositions[x1 + i][y1 - i] != null) {
            return false;
        }
    }
}
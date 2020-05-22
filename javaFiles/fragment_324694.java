public boolean freeWayHorizontally(int xO, int yO, int xD) {
    int destination = xD;
    int origin = xO + 1;
    if (xO > xD) {
        destination = xO - 1;
        origin = xD;
    }

    for (int x = origin; x < destination; x++) {
        if (checkPositionIsFree(x, yO)){
            return false;
        }
    }

    return true;
}
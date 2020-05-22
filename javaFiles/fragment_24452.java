private void recursiveUpdate(final float[][] heightMapping, final boolean[][] traversed,
    final int x, final int z, final float startHeight, final boolean positive) {
    if (x < 0 || x >= width || z < 0 || z >= depth) {
        return;
    }
    if (traversed[x][z]) {
        return;
    }
    if ((positive && startHeight <= 0f) || (!positive && startHeight >= 0f)) {
        heightMapping[x][z] = 0f;
        return;
    }

    traversed[x][z] = true;
    heightMapping[x][z] = startHeight;
    //This will only calculate the corners of the (x,y point)
    recursiveUpdate(heightMapping, traversed, x - 1, z - 1, 
                    calculateNewStartHeight(startHeight, positive), positive);
    recursiveUpdate(heightMapping, traversed, x - 1, z + 1, 
                    calculateNewStartHeight(startHeight, positive), positive);
    recursiveUpdate(heightMapping, traversed, x + 1, z - 1, 
                    calculateNewStartHeight(startHeight, positive), positive);
    recursiveUpdate(heightMapping, traversed, x + 1, z + 1, 
                    calculateNewStartHeight(startHeight, positive), positive);

    //Add top, bottom, left and right indicies for (x,y)
    //bottom
    recursiveUpdate(heightMapping, traversed, x, z - 1, 
                    calculateNewStartHeight(startHeight, positive), positive);
    //top
    recursiveUpdate(heightMapping, traversed, x, z + 1, 
                    calculateNewStartHeight(startHeight, positive), positive);
    //right
    recursiveUpdate(heightMapping, traversed, x + 1, z, 
                    calculateNewStartHeight(startHeight, positive), positive);
    //left
    recursiveUpdate(heightMapping, traversed, x - 1, z, 
                    calculateNewStartHeight(startHeight, positive), positive);
}
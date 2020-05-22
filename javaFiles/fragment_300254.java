for(int z = 0; z < 9; z++) {
    for(int x = 0; x < 13; x++) {
        map[z][x][0] = deepCopy(used);
        map[z][x][1] = deepCopy(move);
    }
}
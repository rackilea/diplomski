public Room (Window w) {
    block = new Block [worldHeight] [worldWidth];
    for (int y=0; y <block.length; y++) {
        for (int x=0; x <block [0].length; x++) {
            block [y] [x] = new Block (x * blockSize, y * blockSize, blockSize, blockSize, Value.groundGrass, Value.airAir, w);
        }
    }
}
public void define(){
    block = new Block[worldHeight][worldWidth];

    for(int y=0;y<block.length;y++){
        for(int x=0;x<block.length;x++){
            block[y][x] = new Block((Screen.myWidth/2) - ((worldWidth * blockSize)/2) + (x * blockSize), y * blockSize, blockSize, blockSize, Value.groundGrass, Value.airAir);
        }
    }
}
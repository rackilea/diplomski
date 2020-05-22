Random random = new Random();
block[x][y] = (Block) Block.air.clone();
if (y > 10) {
    if (random.nextInt(5) == 1) {
        block[x][y] = (Block) Block.dirt.clone();
    }
}
block[x][y].setBounds(x * Block.size, y * Block.size, Block.size, Block.size);
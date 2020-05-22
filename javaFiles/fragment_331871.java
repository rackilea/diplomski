public void draw (Graphics g) {
    for (int y=0; y <block.length; y++) {
        for (int x=0; x <block [0].length; x++) {
            block [y] [x].draw (g);
        }
    }
}
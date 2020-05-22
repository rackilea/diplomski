for(int i=0; i<w; i++){
    for(int j=0; j<h; j++){
        Block b = map[i][j];
        spritebatcher.draw(b.texture, i*b.W, j*b.H);
    }
}
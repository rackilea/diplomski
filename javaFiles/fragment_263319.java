for (int y = 0; y <= mapy; y++){
    for (int x = 0; x <= mapx; x++){
        int L = x * tileWidth;
        int U = y * tileHeight;
        int R =  tileWidth;
        int D =  tileHeight;
        if (map[x][y] == 1){
            g.fillRect(L, U, R, D);
        }
    }

}
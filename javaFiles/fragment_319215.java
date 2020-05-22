boolean isWall(int x, int y) {
     if (x<0||x>3)
        return true;
     if (y<0||y>3)
        return true;
     return data[x][y]==0;
 }
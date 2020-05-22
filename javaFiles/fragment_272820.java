public void capture(int i, int j){
        for (int y=0;y<size;y++) {
            for (int x=0;x<size;x++) {
                if (x==i && y==j) {
                    dots[y][x] = new DotInfo(x, y, currentColor);
                    dots[y][x].setCaptured(true);
                }
            }
        }
    }
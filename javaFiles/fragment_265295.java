public void start() {
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (array[y][x] == 0) {
                    int pos[] = {x,y};
                    path = new ArrayList<int[]>();
                    path.add(pos);
                    startx = x;
                    starty = y;
                    follow(x, y, 1, 0);
                    follow(x, y, -1, 0);
                    follow(x, y, 0, 1);
                    follow(x, y, 0, -1);
                }
            }
        }
    }
private void follow(int x, int y, int dx, int dy) {
        x += dx;
        y += dy;
        while (x >= 0 && x < w && y >= 0 && y < h) {
            if (x == startx && y == starty) {
                for (int[] pos : path) {
                    System.out.printf("[%d,%d] ",pos[1], pos[0]);
                }
                System.out.printf("\n");
                break;
            }
            if (array[y][x] != 0) {
                int pos[] = {x,y};
                path.add(pos);
                if (dx != 0) {
                    follow(x, y, 0, 1);
                    follow(x, y, 0, -1);
                }
                else {
                    follow(x, y, 1, 0);
                    follow(x, y, -1, 0);
                }
                path.remove(path.size()-1);
            }
            x += dx;
            y += dy;
        }
    }
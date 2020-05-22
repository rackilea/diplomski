for (int y = s-1; y >= 0; y--) {

        for (int x = 0; x < v; x++) {

            grid[x][y] = new JLabel((x)+","+(y));

            world.add(grid[x][y]);
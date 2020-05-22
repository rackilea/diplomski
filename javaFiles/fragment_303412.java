public Command move() {
    // randomly determine the moving direction
    // -1 means move left, 1 means move right
    int horizontal_direction = Math.random() > 0.5 ? -1 : 1;
    // -1 means move up, 1 mean move down
    int vertical_direction = Math.random() > 0.5 ? -1 : 1;

    for (int i = 0; i < map.grid.length; i++) {
        for (int j = 0; j < map.grid[i].length; j++) {

            if (map.grid[i][j].equals(rek.getName())) {
                map.grid[i][j] = "Grass"; // replace rek's current position with Grass\

                // if the newRow exceeds the boundaries, don't move in that direction
                int newRow = i + horizontal_direction;
                if (newRow < 0 || newRow == map.grid.length)
                    newRow = i;

                // if the newCol exceeds the boundaries, don't move in that direction
                int newCol = j + vertical_direction;
                if (newCol < 0 || newCol == map.grid[i].length)
                    newCol = j;

                map.grid[newRow][newCol] = rek.getName(); // move rek to the new position

                System.out.println(newRow + "     " + newCol);
                break;
            }
        }
    }
    return null;
}
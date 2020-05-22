JPanel panel = new JPanel(new GridLayout(10, 10));
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            panel.add(new JLabel(String.valueOf(grid[i][j])));
        }
    }
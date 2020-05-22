for(int y=0; y<length; y++){

    for(int x=0; x<width; x++){

        int randomColor = rand.nextInt(5);
        ImageIcon icon = createImageIcon(buttonPics[randomColor]);

        grid[x][y] = new JLabel(icon);
        grid[x][y].addMouseListener(this);
        panel.add(grid[x][y]);

    }
}
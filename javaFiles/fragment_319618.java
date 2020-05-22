if(grid.getButton(i, j).getBackground() == Color.WHITE) {
    if(liveNeighbor == 3) 
        newGrid.getButton(i, j).setBackground(Color.BLUE);
    } else {
        if(liveNeighbor > 3 || liveNeighbor < 2) 
            newGrid.getButton(i, j).setBackground(Color.WHITE);
}
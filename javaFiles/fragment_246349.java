private void FourWaySearch(Node c) {
    if (c.row < 0 || c.row > ROWS - 1 || c.col < 0 || c.col > COLS - 1 || c.hasParent(c.row,c.col))
        return; 
    else {  

        c.data = grid[c.row][c.col];  //get the string value from the word search grid
        if(dictionary.contains(c.toString()))
            foundWords.add(c.toString());
        FourWaySearch(new Node(c,c.row-1,c.col));
        FourWaySearch(new Node(c,c.row,c.col-1));
        FourWaySearch(new Node(c,c.row+1,c.col));
        FourWaySearch(new Node(c,c.row,c.col+1));
    }
}
//col , row : representing the cell you want to find neighbors to 
private void neighbours(int  col, int row) {

     //find all serouding cell by adding +/- 1 to col and row 
    for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {

        for (int rowNum = row - 1 ; rowNum <= (row + 1) ; rowNum +=1  ) {

             //if not the center cell 
            if(! ((colNum == col) && (rowNum == row))) {

                //make sure it is within  grid
                if(withinGrid (colNum, rowNum)) {
                    System.out.println("Neighbor of "+ col+ " "+ row + " - " + colNum +" " + rowNum );
                }
            }
        }
    }
}

 //define if cell represented by colNum, rowNum is inside grid
//function used by neighbours()
private boolean withinGrid(int colNum, int rowNum) {

    if((colNum < 0) || (rowNum <0) ) {
        return false;    //false if row or col are negative
    }
    if((colNum >= COLS) || (rowNum >= ROWS)) {
        return false;    //false if row or col are > 75
    }
    return true;
}
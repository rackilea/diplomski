// top-left to bottom-right - green diagonals
for( rowStart = 0; rowStart < rowMax - 4; rowStart++){
    count = 0;
    int row, col;
    for( row = rowStart, col = 0; row < rowMax && col < colMax; row++, col++ ){
        if(gridTable[row][col] == player){
            count++;
            if(count >= 4) return 1;
        }
        else {
            count = 0;
        }
    }
}

// top-left to bottom-right - red diagonals
for( colStart = 1; colStart < colMax - 4; rowStart++){
    count = 0;
    int row, col;
    for( row = 0, col = colStart; row < rowMax && col < colMax; row++, col++ ){
        if(gridTable[row][col] == player){
            count++;
            if(count >= 4) return 1;
        }
        else {
            count = 0;
        }
    }
}
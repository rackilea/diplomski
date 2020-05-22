if (leftPresent(row,col,o,sol)) {
    updateMat(row, col - 1, o, k, sol);
}
if(rightPresent(row,col,o,sol)) {
     updateMat(row, col + 1, o, k, sol);
}
if(topPresent(row,col,o,sol)) {
    updateMat(row - 1, col, o, k, sol);
}
if(bottomPresent(row,col,o,sol)) {
    updateMat(row + 1, col, o, k, sol);
}
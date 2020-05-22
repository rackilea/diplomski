if (column + 1 < size) {      //go to next column
    checkElements(column + 1, row, open, ufid + 1);
} else if (column + 1 == size && row + 1 < open.length) {  //go to next row 
    checkElements(0, row + 1, open, ufid + 1);
} else {
    return;
}
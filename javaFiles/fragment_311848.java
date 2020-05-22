if (solved)
    return;
if (done(r, c)) {// if within Goal stop and return this maze
    solved=true;
    return ;
} 
if (r > 1 && getCell(r - 1, c) == ' ') {  // Try up first
    setCell(r - 1, c, '*');
    solveMaze(r - 1, c);
    setCell(r - 1, c, ' ');  // Restore the cell back to open and keep trying
} 
if (r < maxRow - 1 && getCell(r + 1, c) == ' ') {  // Down
    setCell(r + 1, c, '*');
    solveMaze(r + 1, c);
    setCell(r + 1, c, ' ');  // Restore the cell back to open and keep trying
} 
if (c < maxCol - 1 && getCell(r, c + 1) == ' ') {  // Right
    setCell(r, c + 1, '*');
    solveMaze(r, c + 1);
    setCell(r, c + 1, ' ');
} 
if (c > 1 && getCell(r, c - 1) == ' ') {  // Left
    setCell(r, c - 1, '*');
     solveMaze(r, c - 1);
    setCell(r, c - 1, ' ');
}
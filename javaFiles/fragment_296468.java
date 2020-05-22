//check right
if(check(row, col, word, puzzle, 1, 0)) return true;

//check left
if(check(row, col, word, puzzle, -1, 0)) return true;

//check top
if(check(row, col, word, puzzle, 0, -1)) return true;

...
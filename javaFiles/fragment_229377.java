if (i+x < Squares.length && j+x < Squares[i].length)
    Squares[i+x][j+x].setEnabled(false);             
if (i-x >= 0 && j-x >= 0)
    Squares[i-x][j-x].setEnabled(false);             
if (i-x >= 0 && j+x < Squares[i].length)
    Squares[i-x][j+x].setEnabled(false);             
if (i+x < Squares.length && j-x >=0)
    Squares[i+x][j-x].setEnabled(false);
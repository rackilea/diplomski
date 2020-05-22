int columnPoint = event.getX() - SEPARATION; 

if (columnPoint < 0 ) // you clicked in the left margin

int columnCell = columnPoint / cellSize;

If (columnCell > NBALLS) // you clicked in the right margin

int cellPoint = columnPoint % cellSize);

if (cellPoint < cellSize / 2)
    // you clicked on the left half
else
    // you clicked on the right half
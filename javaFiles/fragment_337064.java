else{ 
    int[] nc2 = { cell[0]+move[1], cell[1]+move[0] }; 
    if(canMoveToCell(nc2)){
        printMove(cell, nc2);
        nextCellToMoveto=nc2;
        break;
    }
    else{
        nextCellToMoveto=cell;
    }
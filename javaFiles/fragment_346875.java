//if next to another piece, 
            //do not allow to move any further towards said piece
            if(eventX<x&&(x==piece.right+1)){
                return false;
            }else if(eventX>x&&(x==piece.x-width-1)){
                return false;
            }
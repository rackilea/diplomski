void changeColorAtYX(int y, int x){
    if(isWhite(y, x)){
        setBlack(y, x);
    } else {
        setWhite(y,x);
    }
}
private boolean bookSeat(){
    boolean isBooked = false;
    for(int row = 0; row <2; row++){
        for(int col = 0;col<maxCols;col++){
            if (seating[row][col] == false){
                seating[row][col] = true;
                return true;
            }
        }
    }
    return false;
}
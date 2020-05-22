try {
    Vector validMoves = move.DroneMovesNorth[index].Moves;
    int totalMoves = move.DroneTotalMovesNorth[index];
catch(ArrayIndexOutOfBoundsException e) {
    System.out.println("Exception thrown: index = " + index + 
        "Array lengths: " + move.DroneMovesNorth.length + ", " +
        move.DroneTotalMovesNorth.length);
}
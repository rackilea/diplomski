findBestOption(front) {
    bestPosition = null;
    distanceOfBestPosition = Float.MAX_VALUE; //Some very high number to start with.
    for(position in front) {
        distance = Math.sqrt(position.x * position.x - C.x * C.x + position.y * position.y - C.y * C.y); //Euclidean distance (Pythagoras Theorem). This does the diagonal thing for you.
        if(distance < distanceOfBestPosition) {
            distanceOfBestPosition = distance;
            bestPosition = position;
        }
    }
}
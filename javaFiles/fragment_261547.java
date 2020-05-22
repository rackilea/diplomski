//Phase 1
origins = new array[gridLength][gridWidth]; //Keeps track of 'where we came from'.
front = new Set(); //Empty set. You could use an array for this.
front.add(all neighbours of S);
while(true) { //This keeps on looping forever, unless it hits the "break" statement below.
    best = findBestOption(front);
    front.remove(best);
    for(neighbour in (best's neighbours)) {
        if(neighbour is not a tower and origins[neighbour x][neighbour y] == null) { //Not a tower, and not a position that we explored before.
            front.add(neighbour);
            origins[neighbour x][neighbour y] = best;
        }
    }
    if(best == S) {
        break; //Stops the loop. Ends phase 1.
    }
}

//Phase 2
bestPath = new List(); //You should probably use Java's ArrayList class for this if you're allowed to do that. Otherwise select an array size that you know is large enough.
currentPosition = C; //Start at the endpoint.
bestPath.add(C);
while(currentPosition != S) { //Until we're back at the start.
    currentPosition = origins[currentPosition.x][currentPosition.y];
    bestPath.add(currentPosition);
}
bestPath.reverse();
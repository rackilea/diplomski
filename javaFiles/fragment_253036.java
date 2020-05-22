if(mazeExit(startingPoint.getRow(), startingPoint.getColumn(), rows, columns)){ // Checks to see if there is a potential exit
        if(skipFirst>2){ // This makes sure that it does not exit the maze from the entry
            finish = true; // Sets the boolean to true to stop the while loop
            return stack;}} // And returns the stack of coordinates
     // This  code happens only if it does not find any 0's to travel to    
    array[startingPoint.getRow()][startingPoint.getColumn()] = 1; // sets the      space it is on to 1
void move(double[][] arrays, int indexFrom, int posFrom, int indexTo, int posTo) {

    // step 1
    double movedElement = arrays[indexFrom][posFrom];

    // step 2
    // shift all elements that are to the right of the moved element by 1 position left
    for(int j = posFrom + 1; j < arrays[indexFrom].length; j++) {
        arrays[indexFrom][j - 1] = arrays[indexFrom][j];
    }

    // step 3
    // shift all arrays between the array you are moving from 
    // and the array you are moving to
    for(int i = indexFrom + 1; i < indexTo; i++) {
        // move the first element of the next array
        // as the last element of the previous array
        int indexOfLast = arrays[i-1].length - 1;
        arrays[i - 1][indexOfLast] = arrays[i][0];
        // shift remaining elements of the next array
        for(int j = 1; j < arrays[i].length; j++) {
            arrays[i][j - 1] = arrays[i][j];
        }
    }

    // step4

    // store the first element of the array we are moving to
    // as the last element of the previous array
    int indexOfLast = arrays[indexTo - 1].length - 1;
    arrays[indexTo - 1][indexOfLast] = arrays[indexTo][0];

    // starting from the position we are moving to, shift all elements 
    // to the left      
    for(int j = 1; j <= posTo; j++) {
        arrays[indexTo][j - 1] = arrays[indexTo][j];
    }

    // step 5
    // store the moved element at its proper position
    arrays[indexTo][posTo] = movedElement;
}
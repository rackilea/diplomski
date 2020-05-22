boolean arrayIsCorrect = true; //flag to know if array is correct
for(int i=0; i<array.length; i++) { //loop through the array of arrays
    for(int j=0; j<array[i].length; j++) { //loop through the sub-array array[i]
        if(!isCorrect(array[i][j])) {
            arrayIsCorrect = false;
            break; //optimization not required
        }
    }
    if(!arrayIsCorrect) { //optimization not required
        break;
    }
}
System.out.println("Is the array correct ? " + arrayIsCorrect ); //print the result
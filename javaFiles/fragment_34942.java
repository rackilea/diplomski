int endIndex = array2.length; //###  2  ###
while(chunks[i] > count) {
    temp = array2[0]; //###  1  ###

    for(int k = 1; k < endIndex; k++) { //###  2  ###
        //Move all the elements back
        array2[k-1] = array2[k];
    }

    ...
}
endIndex -= chunks[i];
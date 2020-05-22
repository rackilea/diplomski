for(i=0; i<array.length; i++) {        // Iterate through the array
    for( j=0; j<frames.length; j++) {  // Iterate through frames
       if(array[i] == frames[j]) { // if the element is in frames
           MRU = j;
       } else {
           // if the element is not in frames
           frames[MRU] = array[i];   
       }
    }
 }
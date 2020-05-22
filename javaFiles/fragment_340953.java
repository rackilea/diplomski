//sort the array intio a new array
 y[] = x;
 Arrays.sort(y); //sort ascending

 //final array of indexes
 int index_array[] = new int[7];

 //iteretate on x arrat
 for(int i=0; i<7; i++)
    //search the position of a value of the original x array into the sorted y array, store the position in the index array
    index_array[i] = arrays.binarySearch(x,y[i]);
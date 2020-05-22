// index == 2 because the 2nd to last index is 2. remember our array has length 4 and indices 0-3.
minIndex = 3; // this is the index of the last element
if (data[3] < data[2]) { // look at our array 'a', is 6 less than 2?
    return 3; // No it is not. so this is not returned
} else {
    return 2; // we end up return the index (2) of the smaller element (2)
}
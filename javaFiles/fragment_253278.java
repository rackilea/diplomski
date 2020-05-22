int i, j, maxNum, maxInde, temp = 0;
for (i = list.length-1; i >= 0; i--) {
// you start iterating from the end of the list 
// which means that the elements between i and the end of the list are sorted
    maxNum = list[i];
    maxInde = i;
    for (j = 0; j < i; j++) { 
    // you have to iterate through the nonsorted elements
        if (list[j] > maxNum) {
            maxNum = list[j];
            maxInde = j;
        }
    }
    if (maxNum > list[i]) {
    // if you found an element that is bigger then the current element
    // then it should be set as the current element
        temp = list[i];
        list[i] = list[maxInde];
        list[maxInde] = temp;
    }
}
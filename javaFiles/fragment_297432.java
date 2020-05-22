while(true) {
 //ignore all the numbers greater than X to left
 while (A[i] > x) {
        i++;
    }
 //ignore all numbers lesser than X to right
 while (A[j] < x) {
        j--;
 }

 //swap a number lesser than X on left with a number greater than X on right
    if (i < j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        i++;
        j--;
    } else {
        //Now the array is so sorted, that all numbers lesser than X are on right of it and greater than X are to left of it. Hence return position of X
        return j;
    }
 }
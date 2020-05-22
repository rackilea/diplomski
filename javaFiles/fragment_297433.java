while(true) {

 while (A[i] < x) {
        i++;
 }

 while (A[j] > x) {
        j--;
 }

    if (i < j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        i++;
        j--;
    } else {
        return j;
    }
}
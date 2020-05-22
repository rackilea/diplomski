public static void MyAlgorithm(int[] A, int start, int n){
    boolean done = true;
    int j = start;
    while (j <= n - 2){
        if (A[j] > A[j + 1]) {
            swap(A,j,j+1);
            done= false;
        }
        j++;
    }
    j = n - 1;
    while (j >= start+1){
        if (A[j] < A[j - 1]) {
            swap(A,j-1,j);
            done=false;
        }
        j--; 
    }

    if (!done)
        MyAlgorithm(A, start+1, n-1);
    else
        return;
}
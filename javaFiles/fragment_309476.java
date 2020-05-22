for (int i=0; i<m;i++) {
    for (int k=i; k<m;k++) { 
               ^
        int temp = arr[i][k];
        arr[i][k] = arr[k][i];
        arr[k][i] = temp;
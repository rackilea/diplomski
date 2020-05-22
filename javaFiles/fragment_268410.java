int m =//input;
    int[][] arr = new int[m][m];
for(int i=0;i<m;i++){
    for(int j=0;j<m;j++){
        if(i>=j)
        arr[i][j]=i;
        else
            arr[i][j]=j;
        System.out.print(arr[i][j]);
    }
    System.out.println();
}
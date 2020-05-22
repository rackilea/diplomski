for(int i=0;i<row;i++){
  for(int j=0;i<col;i++){
    for(int k=0;i<row;i++){
      matrix[i][j]+=(A[i][k]*B[k][j]);
    } 
  }
}
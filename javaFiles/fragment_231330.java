for(int i =0;i<N;i++){
  for(int j1=0;j1<M;j1++){
    if (A[i][j1]==0)
      continue;
    for(int j2=j1;j2<M;j2++){
      if( A[i][j2]==0){
         //swap
         int tmp=A[i][j1];
         A[i][j1]=A[i][j2];
         A[i][j2]=tmp;
       }
     }
  }
}
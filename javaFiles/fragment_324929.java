int[] getExponents( int n, int k, int max ){
    int[] result = new int[k];
    for(int i=0; i<k; i++)
      result[i]=i+1;
    do{
      if(f(result)==n)
        return result;
    }while(updateExponents(result,max));          
    return null;
  }
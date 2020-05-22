private boolean updateExponents(int[] result, int max) {
    int k = result.length;
    for(int i=k-1; i>=0; i--){
      if(result[i]< max-(k-i))
      {
        result[i]++;
        for(int j=i+1; j<k; k++)
          result[j]=result[j-1]+1;
        return true;
      }
    }
    return false;
  }
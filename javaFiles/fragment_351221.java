Arrays.sort(twoDimArray[twoDimArray.length - 1]);
 //Swap 
 for (int i = 0, j = twoDimArray[twoDimArray.length - 1].length - 1, tmp; i < j; i++, j--) {
     tmp = twoDimArray[twoDimArray.length - 1][i];
     twoDimArray[twoDimArray.length - 1][i] = twoDimArray[twoDimArray.length - 1][j];
     twoDimArray[twoDimArray.length - 1][j] = tmp;
  }
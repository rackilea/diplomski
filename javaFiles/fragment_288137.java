public static int[][] splitArrayByNum(int[] input, int number){
  if (input[0]==number)
    for ( int i = 0 ; i < input.length - 1 ; i++ )
    {
      input[ i ] = input[ i + 1 ] ; 
    }

  if ((input[(input.length)-1])==number)
    for ( int i = (input.length)-1 ; i < input.length - 1 ; i++ )
    {
      input[ i ] = input[ i + 1 ] ; 
    }

  int count = 0;
  for (int i = 0; i < input.length; i++) /*removed bracket here*/
    if (input[i] == number) {
      count++;
    }

  int[][] result = new int[count][];
  int firstindex=0;
  int lastindex=0;

  for (int j=0; j<input.length; j++){

    if (input[j]==number){
      result[j]=Arrays.copyOfRange(input, firstindex, lastindex);
      firstindex=lastindex=j; 
    }
    lastindex++ ; 
  }
  return result ;
}
public static void main( String[] args )
{
  int dice1;
  int dice2;
  // The amount of tests
  final int SIZE = 10000000;

  // store all results we got from a single test
  int[] result = new int[SIZE];

  // loop through the tests
  for(int i = 0; i < SIZE;i++) 
  {
    // initialize counter for every test
    int rolls = 0;
    do 
    {
      // roll counter increases
      rolls++;
      dice1 = (int)(Math.random()*6)+1;
      dice2 = (int)(Math.random()*6)+1;
      // check if condition is met.
    }while(dice1 != 1 || dice2 != 1);
    // store the result of the test
    result[i] = rolls;
  }
  // calculate the average amount of rolls necessary
  double avg = Arrays.stream( result ).sum() / (double)SIZE;
  System.out.println( avg );
}
public static void main (String [] args) {

  //Declare and create array    
  int[] aVariable =  new int[10];
  int[] updatedaVariable = new int[10];

  updatedaVariable = randomValues (aVariable);
  System.out.print("Your random variables are ");

  for(int i : updatedaVariable)
  {
      System.out.print(i + " ");
  }
}

public static int[] randomValues (int random1 []) {
  int[] randomSet = new int[10];

  for (int i = 0; i < randomSet.length; i++) {
      randomSet[i] = (int) (Math.random() * 100);//teacher did not specify max
  }
  return randomSet;
}
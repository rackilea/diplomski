public class Harrison7b
  {
   public static void main(String [] args)
   {
    int[] arrayA = {2,4,8,19,32,17,17,18,25,17,8,3,4,8};
    int varB = 8;
    // Call with the array and variable you need to find.
    int[] result =  newSmallerArray(arrayA, varB);

  for(int x = 0; x < result.length; x++)  {
    System.out.print(result[x] + " ");
   }

 }

  public static int[] newSmallerArray( int[] arrayA, int varB)
   {
  int count = 0;   

  for(int x = 0; x < arrayA.length; x++)
  {
     if(arrayA[x] == varB)
     {
        count++;
     }
  }
     int [] arrayX = new int[arrayA.length - count];

     int index = 0;


  for(int B = 0; B < arrayA.length; B++)
  {
     if(arrayA[B] != varB)
     {
         arrayX[index]= arrayA[B];
       index++;
     }
  }
  return arrayX;
 }
}
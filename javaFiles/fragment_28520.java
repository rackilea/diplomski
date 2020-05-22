public class Test
{
     public static void main(String[] args)
     {//create array of 1,000 random numbers
      int[] randomNumbers = new int[1000];

      for(int i = 0; i < randomNumbers.length; i++)
      randomNumbers[i] =1 +(int)(Math.random() * 6);
      { //initialize count
       int[] counts = countInts(randomNumbers);
       displayIntCount(counts);
      }
     }

    public static int[] countInts(int[] ints)
        { //creat new array to hold occurence values
         int[] counts = new int[6];
         for(int i = 1; i <=counts.length; i++)
             for(int j=0;j<ints.length;j++)
                 if(ints[j] == i)
                     counts[i-1]++;  
         return counts;
        }

     public static void displayIntCount(int[] counts)
      {//display the occurrences
         for (int i = 0; i < counts.length; i++)
             System.out.println("The number "+ (i+1) +" occurs "+counts[i]+ " times");
    } 
}
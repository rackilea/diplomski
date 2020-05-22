public class RandomArray
{
    /*A class that contains an array of random numbers and methods that output
   the numbers' minimum, maximum and average values. Also includes a method
   that outputs a string representation of the numbers.*/
   int size, min, max;
   String array;
   int[] numbers;

   public RandomArray(int sizeOfArray) {
   Random generator = new Random();

   size = sizeOfArray;

   numbers = new int[size];

   for (int i = 0;i < size;i++)
   {
       numbers[i] = generator.nextInt(size + 1);
   }
}
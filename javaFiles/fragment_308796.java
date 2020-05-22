public String toStringArray()//Outputs a string representation of all the numbers in the array
{
   for (int i = 0; i < size;i++)
   {
       array = array + Integer.toString(numbers[i]) + " ";
   }

   return array;
}
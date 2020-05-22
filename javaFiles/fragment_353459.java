public void removeMiddle(int[] values)
{
  //lets say the array size is 10 
   boolean even = (values.length % 2 == 0); 
   int middle1 = values.length/2; 
   int middle2 = values.length/2 - 1; 

   if(even)
   {
       int[] copy = new int[values.length - 2]; 
       //copying the elements 0-3 to the new array
       System.arraycopy(values, 0, copy, 0, copy.length - middle1 -1);
       //copying the last 4 elements to the new array 
       System.arraycopy(values, middle1, copy, middle2, copy.length-middle1 - 1); 
    } 
    else
    {
         int[] copy = new int[values.length - 1]; 
         //copying elements 0-3
         System.arraycopy(copy, 0, copy, 0, copy.length - middle1 -1);
         System.arraycopy(copy, middle1 ,copy, middle1 , copy.length - middle1 -1 );
    }
}
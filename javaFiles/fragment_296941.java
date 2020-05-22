int[] array ={-1, 2, 1};
 boolean max_val_present = false;  

 int min = Integer.MAX_VALUE;

 for(int i=0;i<array.length;i++) // Loop to find the smallest number in array[]
 {
      if(min > array[i] && array[i] > 0)
         min=array[i];
      //Edge Case, if all numbers are negative and a MAX value is present
      if(array[i] == Integer.MAX_VALUE)
        max_val_present = true;
 }

 if(min == Integer.MAX_VALUE && !max_val_present) 
 //no positive value found and Integer.MAX_VALUE 
 //is also not present, return -1 as indicator
    return -1; 

 return min; //return min positive if -1 is not returned
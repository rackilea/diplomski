public static void minGap(int[] list) { //pass it an array of random integers
   // initialize gap with difference of first two elements of array             
   int gap = Math.abs(list[1] - list[0]);
   // Start the array iteration from second element as we already have difference of first two elements.
   for(int i = 2; i < list.length; i++) { //cycle through the array
      // calculate the difference between two adjacent element. 
      int absDiff = Math.abs(list[i] - list[i-1]); 
      // if the difference is less then the prior minimum it becomes the new minimum.
      if(gap > absDiff) {           
         gap = absDiff;
      }
   }
   System.out.println("The minimum gap between 2 adjacent values is " + gap + " "); 
}
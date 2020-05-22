public int findPathLengthRecursive(int i, int j) {
   if (i < 0 || j < 0 || i >= ... ) {
     return 0;
   }

   // Check here that there is an A at the position, otherwise return 0

   // Mark the current position as visited here

   int result = 1 + Math.max(
       Math.max(
          findPathLengthRecursive(i - 1, j),
          findPathLengthRecursive(i + 1, j)),
       Math.max(
          findPathLengthRecursive(i, j - 1),
          findPathLengthRecursive(i, j + 1)));

   // Remove the mark for the current position here

   return result;
 }
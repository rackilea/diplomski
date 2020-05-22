int iAmRecursive(int num) {
   if (num <= 10) // only continue under certain condition
       iAmRecursive(num + 1); 

   // When I get here, I implicitly break out by not recursing.
}
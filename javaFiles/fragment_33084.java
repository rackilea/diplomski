int iAmRecursive(int num) {
   if (num > 10) // break out at some condition; i.e. don't recurse
       return num; // return so the recursion doesn't continue

   iAmRecursive(num + 1); // I didn't break out, so continue to recurse.
}
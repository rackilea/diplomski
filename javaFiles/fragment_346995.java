// Calculate the required height...
/*
   All this loop does, is loops through the array "a"
   and finds the maximum value contained within,
   this is the largest number of times the user
   entered that value

   The loop itself is just an enhanced "for-next-loop", 
   that is, it's a short cutted way of saying...

   for (int index = 0; index < a.length; index++) {
       int value = a[index];
       ...
   }
*/
int maxFrequency = 0;
for (int value : a) {
    // This is a really simply way to calculate the max value within 
    // range, it just says, return me the value which is the larger
    // of two...
    maxFrequency = Math.max(value, maxFrequency);
}
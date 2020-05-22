int secondLargest = 0;
.....
for (..) {
   ....
   if (c % 3 == 0) {
       if (c >= max) {
           secondLargest = max;
           max = c;
       }
       if (c >= secondLargest && c < max) {
           secondLargest = c;
       }
   }
   ....
}
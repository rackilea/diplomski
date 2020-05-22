volatile boolean x;
...
while (true) {
   if (x) {
       y = z;
       break;
   }
}
Boolean value = false;
...
// really bad idea
synchronized (value) {
   if (value) {
      value = false;
   } else {
      value = true;
   }
}
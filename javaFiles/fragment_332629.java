for (Foo f: bar) {
   boolean notEnough=false;
   do {
      ... //this code will be always executed once, at least
     // change notEnough to true if you want to repeat
   } while (notEnough);
}
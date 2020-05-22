if (n==1) {
        System.out.println("move a disk from "+source+" to "+target);
   } else {
        towersOfhanoi(n-1, source, spare, target); 
        towersOfhanoi(1, source, target, spare); 
        towersOfhanoi(n-1, spare, target, source); 
   }
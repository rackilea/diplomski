class EventCounter {
   long counter=0;

   synchronized void up () {
     counter++;
     notifyAll();
   }
   synchronized void ensure (long count) {
     while (counter<count) wait();
   }
 }
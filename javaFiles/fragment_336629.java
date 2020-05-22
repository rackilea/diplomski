while(!killed){
   Event event;
   synchronized (this) {
       // wait until where is something in the queue
       while(eventQueue.isEmpty()){
           this.wait();
       }
       event = eventQueue.get();
   }
   // work with event
   ...
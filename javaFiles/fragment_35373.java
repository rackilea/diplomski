@Override
   protected Integer compute() {

      long thisThreadId = Thread.currentThread().getId();
      if (_threadId != thisThreadId){
          stolen_tasks++;
      }
   // rest of the method
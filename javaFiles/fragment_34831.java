List<Future> futures = ...
 for(...) {
      futures.add(executor.submit(...));
 }

 for(Future f : futures) {
       //this will throw an exception if an exception
       //occurred executing the task, insert error handling as 
       //appropriate, perhaps calling cancel on tasks that
       //have not yet completed
       f.get();
 }
 //at this point all tasks have completed
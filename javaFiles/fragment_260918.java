private char readChar(final InputStream in){
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //set the executor thread working
        Callable<Integer> task = new Callable<Integer>() {
            public Integer call() {
               try {
                   return in.read();
               } catch (Exception e) {
                  //do nothing
               }
               return null;
            }
         };

         Future<Integer> future = executor.submit(task);
         Integer result =null;
         try {
              result= future.get(1, TimeUnit.SECONDS); //timeout of 1 sec
          } catch (TimeoutException ex) {
              //do nothing
          } catch (InterruptedException e) {
             // handle the interrupts
          } catch (ExecutionException e) {
             // handle other exceptions
          } finally {
              future.cancel(false);
              executor.shutdownNow();
           }

         if(result==null)
             return (char) -1;
        return  (char) result.intValue();
    }